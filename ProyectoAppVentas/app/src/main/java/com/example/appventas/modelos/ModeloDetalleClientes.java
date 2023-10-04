package com.example.appventas.modelos;

import com.example.appventas.Detalles.DetalleClientes;
import com.example.appventas.entidades.CreditoRequest;
import com.example.appventas.entidades.RespuestaApi;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloDetalleClientes {
    DetalleClientes activity;

    public ModeloDetalleClientes(DetalleClientes activity) {
        this.activity = activity;
    }
    public void eliminarCliente(int id){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<RespuestaApi> call = apiInterface.eliminarCliente(id);
        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                RespuestaApi respuesta = (RespuestaApi) response.body();
                activity.respuesta(respuesta);
            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                System.out.println("fallo al eliminar");
            }
        });
    }
    public void ampliarCredito(int id,double credito){
        CreditoRequest creditoRequest = new CreditoRequest(credito);
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<RespuestaApi> call = apiInterface.aumentarCredito(id,creditoRequest);
        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                RespuestaApi respuesta = (RespuestaApi) response.body();
                activity.respuesta(respuesta);
            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {
                System.out.println("fallo al ampliar credito");
            }
        });
    }
}
