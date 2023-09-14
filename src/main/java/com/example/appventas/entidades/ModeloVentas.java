package com.example.appventas.entidades;

public class ModeloVentas {
    private int folio;
    private int cliente;
    private String productos;
    private double importe;
    private String fechaVenta;

    public ModeloVentas() {}

    public ModeloVentas(int folio, int cliente, String productos, double importe, String fechaVenta) {
        this.folio = folio;
        this.cliente = cliente;
        this.productos = productos;
        this.importe = importe;
        this.fechaVenta = fechaVenta;
    }

    public ModeloVentas(int cliente, String productos, double importe, String fechaVenta) {
        this.cliente = cliente;
        this.productos = productos;
        this.importe = importe;
        this.fechaVenta = fechaVenta;
    }

    public int getFolio() {
        return folio;
    }

    public int getCliente() {
        return cliente;
    }

    public String getProductos() {
        return productos;
    }

    public double getImporte() {
        return importe;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }
}
