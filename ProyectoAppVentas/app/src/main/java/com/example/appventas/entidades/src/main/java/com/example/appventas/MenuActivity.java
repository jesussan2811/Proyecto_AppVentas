package com.example.appventas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.appventas.MenuFragments.ClientesFragment;
import com.example.appventas.MenuFragments.ProductosFragment;
import com.example.appventas.MenuFragments.VentasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    ClientesFragment clientesFragment = new ClientesFragment();
    ProductosFragment productosFragment = new ProductosFragment();
    VentasFragment ventasFragment = new VentasFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navegacion = findViewById(R.id.bottom_navigation);
        navegacion.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.clientes:
                    loadFragment(clientesFragment);
                    return true;
                case R.id.ventas:
                    loadFragment(ventasFragment);
                    return true;
                case R.id.productos:
                    loadFragment(productosFragment);
                    return true;
            }
            return false;
        }
    };
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.menuFramelayout, fragment);
        transaction.commit();
    }
}