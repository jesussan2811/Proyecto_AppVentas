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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    Button btnRegistrar;
    EditText txtUsuario;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario = (EditText)findViewById(R.id.editTextUsuario);
        txtPassword = (EditText)findViewById(R.id.editTextPassword);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = txtUsuario.getText().toString();
                String password = txtPassword.getText().toString();
                AppVentasBD appVentasBD = new AppVentasBD(getApplicationContext());

                if (appVentasBD.buscarUsuario(usuario,password)){
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

}