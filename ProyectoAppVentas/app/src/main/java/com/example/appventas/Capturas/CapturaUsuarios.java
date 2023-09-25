package com.example.appventas.Capturas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appventas.AppVentasBD;
import com.example.appventas.R;

public class CapturaUsuarios extends AppCompatActivity {

    EditText nvoUsername;
    EditText nvoPassword;
    EditText claveEmpresa;

    Button btnEnviar;
    Button btnSalir;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_usuarios);

        nvoUsername = (EditText)findViewById(R.id.CapUserName);;
        nvoPassword = (EditText)findViewById(R.id.CapUserPassword);;
        claveEmpresa = (EditText)findViewById(R.id.CapUserClave);;

        btnSalir = (Button) findViewById(R.id.CapSalir);
        btnEnviar = (Button) findViewById(R.id.CapEnviar);

        builder = new AlertDialog.Builder(this);
        final AppVentasBD appVentasBD = new AppVentasBD(getApplicationContext());

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = nvoUsername.getText().toString();
                String contrasenia = nvoPassword.getText().toString();
                String clave = claveEmpresa.getText().toString();

                if (validarcampos(usuario,contrasenia,clave)){//
                    if(clave != "79520"){
                        Toast.makeText(getBaseContext(),"Nuevo Usuario Registrado",Toast.LENGTH_LONG).show();
                        appVentasBD.agregarUsuario(usuario,contrasenia);
                        finish();
                    }else{
                        Toast.makeText(getBaseContext(),"La clave es incorrecta",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getBaseContext(),"Llena todos los campos",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public boolean validarcampos(String usuario,String contrasenia,String clave){
        boolean valido = true;

        if(usuario.length() == 0)
            valido = false;
        if(contrasenia.length() == 0)
            valido = false;
        if(clave.length() == 0)
            valido = false;

        return valido;
    }
}