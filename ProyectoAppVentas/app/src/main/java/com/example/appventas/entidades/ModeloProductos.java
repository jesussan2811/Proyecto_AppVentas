package com.example.appventas.entidades;


import java.io.Serializable;

@SuppressWarnings("serial")
public class ModeloProductos implements Serializable {
    private int CODIGO;
    private String PRODNOMBRE;
    private String DESCRIPCION;
    private String MARCA;
    private int CANTIDAD;
    private double PRECIO;

    public ModeloProductos() {}

    public ModeloProductos(int codigo, String prodNombre, String descripcion, String marca, int cantidad, double precio) {
        this.CODIGO = codigo;
        this.PRODNOMBRE = prodNombre;
        this.DESCRIPCION = descripcion;
        this.MARCA = marca;
        this.CANTIDAD = cantidad;
        this.PRECIO = precio;
    }

    public ModeloProductos(String prodNombre, String descripcion, String marca, int cantidad, double precio) {
        this.PRODNOMBRE = prodNombre;
        this.DESCRIPCION = descripcion;
        this.MARCA = marca;
        this.CANTIDAD = cantidad;
        this.PRECIO = precio;
    }

    public int getCodigo() {
        return CODIGO;
    }

    public String getProdNombre() {
        return PRODNOMBRE;
    }

    public String getDescripcion() {
        return DESCRIPCION;
    }

    public String getMarca() {
        return MARCA;
    }

    public int getCantidad() {
        return CANTIDAD;
    }

    public double getPrecio() {
        return PRECIO;
    }

}
