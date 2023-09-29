package com.example.appventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appventas.Capturas.CapturaUsuarios;
import com.example.appventas.entidades.ModeloUsuarios;
import com.example.appventas.modelos.ModeloMainActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    Button btnRegistrar;
    EditText txtUsuario;
    EditText txtPassword;

    ArrayList<ModeloUsuarios> listaUsuarios;
    ModeloMainActivity modeloMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText)findViewById(R.id.editTextUsuario);
        txtPassword = (EditText)findViewById(R.id.editTextPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        modeloMainActivity = new ModeloMainActivity(this);
        listaUsuarios = new ArrayList<>();

        modeloMainActivity.getListaUsuarios();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = txtUsuario.getText().toString();
                String password = txtPassword.getText().toString();
                //AppVentasBD appVentasBD = new AppVentasBD(getApplicationContext());

                //if (appVentasBD.buscarUsuario(usuario,password)){
                if (buscarUsuario(listaUsuarios,usuario,password)){
                    Toast.makeText(getBaseContext(),"Inicio de sesion confirmado: Bienvenido "+usuario,Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(this, CapturaProspectos.class);
                    Intent intent = new Intent(getBaseContext(),MenuActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(),"Inicio de sesion fallido: usuario o contraseña incorrecto",Toast.LENGTH_LONG).show();
                }

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(this, CapturaProspectos.class);
                Intent intent = new Intent(getBaseContext(), CapturaUsuarios.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        modeloMainActivity.getListaUsuarios();
    }

    public void obtenerUsuarios(ArrayList<ModeloUsuarios> usuarios){
        listaUsuarios = usuarios;
    }

    public boolean buscarUsuario(ArrayList<ModeloUsuarios> usuarios, String nombre, String contrasenia){
        if(usuarios.isEmpty())
            return false;
        else{
            for (int i = 0; i < usuarios.size(); i++){
                if (usuarios.get(i).getUserName().equals(nombre)){
                    if (usuarios.get(i).getPassword().equals(contrasenia))
                        return true;
                }
            }
        }
        return false;
    }

}