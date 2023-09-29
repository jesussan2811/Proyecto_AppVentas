package com.example.appventas.modelos;

import com.example.appventas.MenuFragments.ClientesFragment;
import com.example.appventas.entidades.ModeloClientes;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloClientesFragment {
    ClientesFragment clientesFragment;

    public ModeloClientesFragment(ClientesFragment clientesFragment) {
        this.clientesFragment = clientesFragment;
    }
    public void getListaClientes(){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<List<ModeloClientes>> call = apiInterface.getClientes();
        call.enqueue(new Callback<List<ModeloClientes>>() {
            //Aqui se obtiene la respuesta del servicio
            @Override
            public void onResponse(Call<List<ModeloClientes>> call, Response<List<ModeloClientes>> response) {
                ArrayList<ModeloClientes> clientes = new ArrayList<>();
                clientes = (ArrayList<ModeloClientes>) response.body();
                //se manda a llamar metodo para mostrar los resultados del servicio
                clientesFragment.mostrarClientes(clientes);
            }

            @Override
            public void onFailure(Call<List<ModeloClientes>> call, Throwable t) {
                System.out.println("no funciono");
            }
        });
    }
}
