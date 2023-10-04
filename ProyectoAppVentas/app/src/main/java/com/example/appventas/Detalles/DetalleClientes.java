package com.example.appventas.Detalles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appventas.AppVentasBD;
import com.example.appventas.R;
import com.example.appventas.entidades.ModeloClientes;
import com.example.appventas.entidades.RespuestaApi;
import com.example.appventas.modelos.ModeloDetalleClientes;

public class DetalleClientes extends AppCompatActivity {
    TextView dtCliID;
    TextView dtCliNombre;
    TextView dtCliApellidos;
    TextView dtCliCredito;
    TextView dtCliTelefono;
    TextView dtCliDomicilio;
    TextView dtCliFechaNacimiento;

    Button btnregresar;
    Button btnEliminar;
    Button btnSumarCredito;

    EditText dtCreditoASumar;

    ModeloDetalleClientes modeloDetalleClientes;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_clientes);

        dtCliID = (TextView)findViewById(R.id.DetalCliID);
        dtCliNombre = (TextView)findViewById(R.id.DetalCliNombre);
        dtCliApellidos = (TextView)findViewById(R.id.DetalCliApellidos);
        dtCliCredito = (TextView)findViewById(R.id.DetalCliCredito);
        dtCliTelefono = (TextView)findViewById(R.id.DetalCliTelefono);
        dtCliDomicilio = (TextView)findViewById(R.id.DetalCliDomicilio);
        dtCliFechaNacimiento = (TextView)findViewById(R.id.DetalCliFechaNacimiento);

        btnregresar = (Button) findViewById(R.id.DetalCliRegresar);
        btnEliminar = (Button) findViewById(R.id.EliminarCliente);
        btnSumarCredito = (Button) findViewById(R.id.SumarCredito);

        dtCreditoASumar = (EditText) findViewById(R.id.EditTextCreditoASumar);

        modeloDetalleClientes = new ModeloDetalleClientes(this);

        builder = new AlertDialog.Builder(this);
        //final AppVentasBD appVentasBD=new AppVentasBD(getApplicationContext());

        Intent intent = getIntent();
        ModeloClientes cliente = (ModeloClientes) intent.getSerializableExtra("Cliente");
        dtCliID.setText(""+cliente.getCliID());
        dtCliNombre.setText(cliente.getCliNombre());
        dtCliApellidos.setText(cliente.getApellido());
        dtCliCredito.setText(""+cliente.getCredito());
        dtCliTelefono.setText(cliente.getTelefono());
        dtCliDomicilio.setText(cliente.getDomicilio());
        dtCliFechaNacimiento.setText(cliente.getFechaNacimiento().substring(0,10));

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
                                //appVentasBD.eliminarCliente(cliente.getCliID());
                                modeloDetalleClientes.eliminarCliente(cliente.getCliID());
                                finish();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                break;
                        }
                    }
                };
                builder.setMessage("Seguro que quieres Eliminar este Cliente?").setPositiveButton("Si", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
        btnSumarCredito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtCreditoASumar = dtCreditoASumar.getText().toString();
                double creditoASumar = Double.parseDouble(txtCreditoASumar);

                if (txtCreditoASumar.length() != 0 && creditoASumar > 0.0) {
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    modeloDetalleClientes.ampliarCredito(cliente.getCliID(),creditoASumar);
                                    finish();
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:

                                    break;
                            }
                        }
                    };


                    builder.setMessage("Estas seguro que quieres añadir esta cantidad?").setPositiveButton("Si", dialogClickListener)
                            .setNegativeButton("No", dialogClickListener).show();
                }
                else{
                    Toast.makeText(getBaseContext(),"Ingresa la cantidad para tu credito",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void respuesta(RespuestaApi respuestaApi){
        Toast.makeText(this,respuestaApi.mensaje,Toast.LENGTH_LONG).show();
    }
}