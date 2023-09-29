package com.example.appventas.modelos;

import com.example.appventas.Capturas.CapturaUsuarios;

import com.example.appventas.entidades.ModeloUsuarios;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloCapturaUsuarios {
    CapturaUsuarios activity;

    public ModeloCapturaUsuarios(CapturaUsuarios activity) {
        this.activity = activity;
    }
    public void postUsuario(ModeloUsuarios usuario){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<ModeloUsuarios> call = apiInterface.postUsuario(usuario);
        call.enqueue(new Callback<ModeloUsuarios>() {
            @Override
            public void onResponse(Call<ModeloUsuarios> call, Response<ModeloUsuarios> response) {
                ModeloUsuarios respuesta = (ModeloUsuarios) response.body();
                if(respuesta != null)
                    activity.mostrarRespuesta("se ha dado de alta");
                else
                    activity.mostrarRespuesta("no se dio de alta");

            }

            @Override
            public void onFailure(Call<ModeloUsuarios> call, Throwable t) {
                System.out.println("fallo al Capturar");
            }
        });
    }
}
