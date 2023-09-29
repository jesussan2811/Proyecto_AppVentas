package com.example.appventas.modelos;

import com.example.appventas.Capturas.CapturaProductos;
import com.example.appventas.entidades.ModeloProductos;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloCapturaProductos {
    CapturaProductos activity;

    public ModeloCapturaProductos(CapturaProductos activity) {
        this.activity = activity;
    }
    public void postProducto(ModeloProductos producto){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<ModeloProductos> call = apiInterface.postProducto(producto);
        call.enqueue(new Callback<ModeloProductos>() {
            @Override
            public void onResponse(Call<ModeloProductos> call, Response<ModeloProductos> response) {
                ModeloProductos respuesta = (ModeloProductos) response.body();
                if(respuesta != null)
                    activity.mostrarRespuesta("se ha dado de alta");
                else
                    activity.mostrarRespuesta("no se dio de alta");

            }

            @Override
            public void onFailure(Call<ModeloProductos> call, Throwable t) {
                System.out.println("fallo al Capturar");
            }
        });
    }
}
