package com.example.appventas.modelos;

import com.example.appventas.MenuFragments.ProductosFragment;

import com.example.appventas.entidades.ModeloProductos;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloProductosFragment {
    ProductosFragment productosFragment;

    public ModeloProductosFragment(ProductosFragment productosFragment) {
        this.productosFragment = productosFragment;
    }
    public void getListaProductos(){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<List<ModeloProductos>> call = apiInterface.getProductos();
        call.enqueue(new Callback<List<ModeloProductos>>() {
            //Aqui se obtiene la respuesta del servicio
            @Override
            public void onResponse(Call<List<ModeloProductos>> call, Response<List<ModeloProductos>> response) {
                ArrayList<ModeloProductos> productos = new ArrayList<>();
                productos = (ArrayList<ModeloProductos>) response.body();
                //se manda a llamar metodo para mostrar los resultados del servicio
                productosFragment.mostrarProductos(productos);
            }

            @Override
            public void onFailure(Call<List<ModeloProductos>> call, Throwable t) {
                System.out.println("no funciono");
            }
        });
    }
}
