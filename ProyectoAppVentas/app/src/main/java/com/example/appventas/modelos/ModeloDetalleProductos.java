package com.example.appventas.modelos;

import com.example.appventas.Detalles.DetalleProductos;
import com.example.appventas.entidades.RespuestaApi;
import com.example.appventas.entidades.StockRequest;
import com.example.appventas.servicos.APIinterface;
import com.example.appventas.servicos.RetrifitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloDetalleProductos {
    DetalleProductos activity;

    public ModeloDetalleProductos(DetalleProductos activity) {
        this.activity = activity;
    }
    public void eliminarProducto(int id){
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<RespuestaApi> call = apiInterface.eliminarProducto(id);
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
    public void ampliarStock(int id,int stock){
        StockRequest stockRequest = new StockRequest(stock);
        APIinterface apiInterface = RetrifitInstance.getRetrofitInstance("http://192.168.100.9:4040/").create(APIinterface.class);
        Call<RespuestaApi> call = apiInterface.aumentarStock(id,stockRequest);
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
