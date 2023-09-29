package com.example.appventas.modelos;

import com.example.appventas.Capturas.CapturaClientes;
import com.example.appventas.entidades.ModeloClientes;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloCapturaClientes {
    CapturaClientes activity;

    public ModeloCapturaClientes(CapturaClientes activity) {
        this.activity = activity;
    }
    public void postCliente(ModeloClientes cliente){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<ModeloClientes> call = apiInterface.postCliente(cliente);
        call.enqueue(new Callback<ModeloClientes>() {
            @Override
            public void onResponse(Call<ModeloClientes> call, Response<ModeloClientes> response) {
                ModeloClientes respuesta = (ModeloClientes) response.body();
                if(respuesta != null)
                    activity.mostrarRespuesta("se ha dado de alta");
                else
                    activity.mostrarRespuesta("no se dio de alta");

            }

            @Override
            public void onFailure(Call<ModeloClientes> call, Throwable t) {
                System.out.println("fallo al Capturar");
            }
        });
    }
}
