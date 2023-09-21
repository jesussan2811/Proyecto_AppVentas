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

public class CapturaProductos extends AppCompatActivity {

    EditText nvoNombre;
    EditText nvoDescripcion;
    EditText nvoMarca;
    EditText nvoCantidad;
    EditText nvoPrecio;
    Button btnEnviar;
    Button btnSalir;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_productos);

        nvoNombre = (EditText)findViewById(R.id.CapProdNombre);
        nvoDescripcion = (EditText)findViewById(R.id.CapProdDescripcion);
        nvoMarca = (EditText)findViewById(R.id.CapProdMarca);
        nvoCantidad = (EditText)findViewById(R.id.CapProdCantidad);
        nvoPrecio = (EditText)findViewById(R.id.CapProdPrecio);

        btnSalir = (Button) findViewById(R.id.CapSalir);
        btnEnviar = (Button) findViewById(R.id.CapEnviar);


        builder = new AlertDialog.Builder(this);
        final AppVentasBD appVentasBD = new AppVentasBD(getApplicationContext());

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nvoNombre.getText().toString();
                String descripcion = nvoDescripcion.getText().toString();
                String marca = nvoMarca.getText().toString();
                String cantidad = nvoCantidad.getText().toString();
                String precio = nvoPrecio.getText().toString();


                if(validarcampos(nombre,descripcion,marca,cantidad,precio)){
                    Toast.makeText(getBaseContext(),"Nuevo Producto Capturado",Toast.LENGTH_LONG).show();
                    appVentasBD.agregarProducto(nombre,descripcion,marca,Integer.parseInt(cantidad),Double.parseDouble(precio));
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
    public boolean validarcampos(String nombre,String descripcion,String marca,String cantidad,String precio){
        boolean valido = true;

        if(nombre.length() == 0)
            valido = false;
        if(descripcion.length() == 0)
            valido = false;
        if(marca.length() == 0)
            valido = false;
        if(cantidad.length() == 0)
            valido = false;
        if(precio.length() == 0)
            valido = false;


        return valido;
    }
}