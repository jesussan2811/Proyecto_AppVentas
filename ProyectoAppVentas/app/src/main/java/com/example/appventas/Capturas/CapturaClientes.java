package com.example.appventas.Capturas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appventas.AppVentasBD;
import com.example.appventas.R;

public class CapturaClientes extends AppCompatActivity {

    EditText nvoNombre;
    EditText nvoApellidos;
    EditText nvoCredito;
    EditText nvoTelefono;
    EditText nvoDomicilio;
    EditText nvoFechaNacimiento;
    Button btnEnviar;
    Button btnSalir;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_clientes);

        nvoNombre = (EditText)findViewById(R.id.CapCliNombre);
        nvoApellidos = (EditText)findViewById(R.id.CapCliApellidos);
        nvoCredito = (EditText)findViewById(R.id.CapCliCredito);
        nvoTelefono = (EditText)findViewById(R.id.CapCliTelefono);
        nvoDomicilio = (EditText)findViewById(R.id.CapCliDomicilio);
        nvoFechaNacimiento = (EditText)findViewById(R.id.CapCliFechaNacimiento);

        btnSalir = (Button) findViewById(R.id.CapSalir);
        btnEnviar = (Button) findViewById(R.id.CapEnviar);


        builder = new AlertDialog.Builder(this);
        final AppVentasBD appVentasBD = new AppVentasBD(getApplicationContext());

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nvoNombre.getText().toString();
                String apellidos = nvoApellidos.getText().toString();
                String credito = nvoCredito.getText().toString();
                String telefono = nvoTelefono.getText().toString();
                String domicilio = nvoDomicilio.getText().toString();
                String fechaNacimiento = nvoFechaNacimiento.getText().toString();


                if(validarcampos(nombre,apellidos,credito,telefono,domicilio,fechaNacimiento)){
                    Toast.makeText(getBaseContext(),"Nuevo Cliente Capturado",Toast.LENGTH_LONG).show();
                    appVentasBD.agregarCliente(nombre,apellidos,Double.parseDouble(credito),telefono,domicilio,fechaNacimiento);
                }else{
                    Toast.makeText(getBaseContext(),"Llena todos los campos",Toast.LENGTH_LONG).show();

                }


            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };


                builder.setMessage("Seguro que quieres Salir?").setPositiveButton("Si", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
    }

    public boolean validarcampos(String nombre,String apellidos,String credito,String telefono,String domicilio,String fechaNacimiento){
        boolean valido = true;

        if(nombre.length() == 0)
            valido = false;
        if(apellidos.length() == 0)
            valido = false;
        if(credito.length() == 0)
            valido = false;
        if(telefono.length() < 10)
            valido = false;
        if(domicilio.length() == 0)
            valido = false;
        if(fechaNacimiento.length() < 10)
            valido = false;


        return valido;
    }

    public void mostrarRespuesta(String respuesta){
        Toast.makeText(this,respuesta,Toast.LENGTH_LONG).show();
        if(respuesta.compareTo("se ha dado de alta") == 0)
        {
            finish();
        }
    }
}