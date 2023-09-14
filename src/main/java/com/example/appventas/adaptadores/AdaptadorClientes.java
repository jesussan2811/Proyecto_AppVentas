package com.example.appventas.adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appventas.R;
import com.example.appventas.entidades.ModeloClientes;

import java.util.List;

public class AdaptadorClientes extends RecyclerView.Adapter<AdaptadorClientes.ViewHolder> {

    private List<ModeloClientes> Clientes;
    private Activity activity;

    public AdaptadorClientes(Activity activity, List<ModeloClientes> Clientes) {
        this.Clientes = Clientes;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cliente,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(Clientes.get(position).getCliNombre());
        holder.apellidos.setText(Clientes.get(position).getApellido());
        holder.credito.setText(Clientes.get(position).getCredito()+"");
        holder.telefono.setText(Clientes.get(position).getTelefono());

    }

    @Override
    public int getItemCount() {
        return Clientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, apellidos, credito, telefono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvCliNombre);
            apellidos = itemView.findViewById(R.id.tvCliApellidos);
            credito = itemView.findViewById(R.id.tvCliCredito);
            telefono = itemView.findViewById(R.id.tvCliTelefono);

        }
    }
}