package com.example.appventas.adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appventas.Detalles.DetalleProductos;
import com.example.appventas.R;
import com.example.appventas.entidades.ModeloProductos;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ViewHolder> {

    private ArrayList<ModeloProductos> Productos;
    private Activity activity;

    public AdaptadorProductos(Activity activity, ArrayList<ModeloProductos> Productos) {
        this.Productos = Productos;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.codigo.setText(Productos.get(position).getCodigo()+"");
        holder.nombre.setText(Productos.get(position).getProdNombre());
        holder.cantidad.setText(Productos.get(position).getCantidad()+"");
        holder.precio.setText(Productos.get(position).getPrecio()+"");

        //Se agrega el evento click al item seleccionado de la lista
        //para mostrar el detalle
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetalleProductos.class);
                intent.putExtra("Producto", Productos.get(holder.getAdapterPosition()));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView codigo, nombre, cantidad, precio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.tvProdCodigo);
            nombre = itemView.findViewById(R.id.tvProdNombre);
            cantidad = itemView.findViewById(R.id.tvProdCantidad);
            precio = itemView.findViewById(R.id.tvProdPrecio);

        }
    }
}
