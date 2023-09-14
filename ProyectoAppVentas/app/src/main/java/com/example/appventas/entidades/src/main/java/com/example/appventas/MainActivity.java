package com.example.appventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    Button btnRegistrar;
    EditText txtUsuario;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(this, CapturaProspectos.class);
                Intent intent = new Intent(getBaseContext(),MenuActivity.class);
                startActivity(intent);
            }
        });

        /*btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(this, CapturaProspectos.class);
                Intent intent = new Intent(getBaseContext(),CapturaProspectos.class);
                startActivity(intent);
            }
        });*/

    }
}