package com.example.appventas.entidades;


import java.io.Serializable;

@SuppressWarnings("serial")
public class ModeloProductos implements Serializable {
    private int codigo;
    private String prodNombre;
    private String descripcion;
    private String marca;
    private int cantidad;
    private double precio;

    public ModeloProductos() {}

    public ModeloProductos(int codigo, String prodNombre, String descripcion, String marca, int cantidad, double precio) {
        this.codigo = codigo;
        this.prodNombre = prodNombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ModeloProductos(String prodNombre, String descripcion, String marca, int cantidad, double precio) {
        this.prodNombre = prodNombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

}
