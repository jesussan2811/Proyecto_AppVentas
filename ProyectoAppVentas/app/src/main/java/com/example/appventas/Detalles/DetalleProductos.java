package com.example.appventas.Detalles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appventas.AppVentasBD;
import com.example.appventas.R;
import com.example.appventas.entidades.ModeloProductos;

public class DetalleProductos extends AppCompatActivity {
    TextView dtProdCodigo;
    TextView dtProdNombre;
    TextView dtProdDescripcion;
    TextView dtProdMarca;
    TextView dtProdCantidad;
    TextView dtProdPrecio;

    Button btnregresar;
    Button btnEliminar;
    Button btnEditar;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_productos);

        dtProdCodigo = (TextView)findViewById(R.id.DetalProdCodigo);
        dtProdNombre = (TextView)findViewById(R.id.DetalProdNombre);
        dtProdDescripcion = (TextView)findViewById(R.id.DetalProdDescripcion);
        dtProdMarca = (TextView)findViewById(R.id.DetalProdMarca);
        dtProdCantidad = (TextView)findViewById(R.id.DetalProdCantidad);
        dtProdPrecio = (TextView)findViewById(R.id.DetalProdPrecio);

        btnregresar = (Button) findViewById(R.id.DetalProdRegresar);
        btnEliminar = (Button) findViewById(R.id.EliminarProducto);
        btnEditar = (Button) findViewById(R.id.EditarProducto);

        builder = new AlertDialog.Builder(this);
        final AppVentasBD appVentasBD=new AppVentasBD(getApplicationContext());

        Intent intent = getIntent();
        ModeloProductos producto = (ModeloProductos) intent.getSerializableExtra("Producto");
        dtProdCodigo.setText(""+producto.getCodigo());
        dtProdNombre.setText(producto.getProdNombre());
        dtProdDescripcion.setText(producto.getDescripcion());
        dtProdMarca.setText(producto.getMarca());
        dtProdCantidad.setText(""+producto.getCantidad());
        dtProdPrecio.setText(""+producto.getPrecio());

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                appVentasBD.eliminarProducto(producto.getCodigo());
                                Toast.makeText(getBaseContext(),"Se ha eliminado un Producto",Toast.LENGTH_LONG).show();
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };


                builder.setMessage("Seguro que quieres Eliminar este Producto?").setPositiveButton("Si", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
    }
}