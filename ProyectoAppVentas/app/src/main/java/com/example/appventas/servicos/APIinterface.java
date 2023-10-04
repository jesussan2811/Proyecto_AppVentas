package com.example.appventas.servicos;

import com.example.appventas.entidades.CreditoRequest;
import com.example.appventas.entidades.ModeloClientes;
import com.example.appventas.entidades.ModeloProductos;
import com.example.appventas.entidades.ModeloUsuarios;
import com.example.appventas.entidades.ModeloVentas;
import com.example.appventas.entidades.RespuestaApi;
import com.example.appventas.entidades.StockRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIinterface {

    @Headers("Content-Type: application/json")

    //      CLIENTES
    @GET("allClientes")
    Call<List<ModeloClientes>>getClientes();

    @POST("/addCliente")
    Call<ModeloClientes>postCliente(@Body ModeloClientes Cliente);

    @DELETE("/clientes/delete/{id}")
    Call<RespuestaApi>eliminarCliente(@Path("id") int id);

    @PUT("/clientes/update/{id}")
    Call<RespuestaApi>aumentarCredito(@Path("id") int id, @Body CreditoRequest creditoRequest);

    //      USUARIOS
    @GET("allUsuarios")
    Call<List<ModeloUsuarios>>getUsuarios();

    @POST("/addUsuarios")
    Call<ModeloUsuarios>postUsuario(@Body ModeloUsuarios Usuario);

    //      PRODUCTOS
    @GET("allProductos")
    Call<List<ModeloProductos>>getProductos();

    @POST("/addProducto")
    Call<ModeloProductos>postProducto(@Body ModeloProductos Producto);

    @DELETE("/productos/delete/{id}")
    Call<RespuestaApi>eliminarProducto(@Path("id") int id);

    @PUT("/productos/update/{id}")
    Call<RespuestaApi>aumentarStock(@Path("id") int id, @Body StockRequest stockRequest);

    //      VENTAS
    @GET("allVentas")
    Call<List<ModeloVentas>>getVentas();

    @POST("/addVenta")
    Call<ModeloVentas>postUsuario(@Body ModeloVentas Venta);
}
