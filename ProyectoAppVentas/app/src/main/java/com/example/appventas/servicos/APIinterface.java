package com.example.appventas.servicos;

import com.example.appventas.entidades.ModeloClientes;
import com.example.appventas.entidades.ModeloProductos;
import com.example.appventas.entidades.ModeloUsuarios;
import com.example.appventas.entidades.ModeloVentas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
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

    //      VENTAS
    @GET("allVentas")
    Call<List<ModeloVentas>>getVentas();

    @POST("/addVenta")
    Call<ModeloVentas>postUsuario(@Body ModeloVentas Venta);
}
