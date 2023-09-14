package com.example.appventas.entidades;

public class ModeloClientes {
    private int cliID;
    private String cliNombre;
    private String apellido;
    private double credito;
    private String telefono;
    private String domicilio;
    private String fechaNacimiento;

    public ModeloClientes(){}

    public ModeloClientes(int cliID, String cliNombre, String apellido, double credito, String telefono, String domicilio, String fechaNacimiento){
        this.cliID = cliID;
        this.cliNombre = cliNombre;
        this.apellido = apellido;
        this.credito = credito;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
    }
    public ModeloClientes(String cliNombre, String apellido, double credito, String telefono, String domicilio, String fechaNacimiento){
        this.cliNombre = cliNombre;
        this.apellido = apellido;
        this.credito = credito;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCliID() {
        return cliID;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getCredito() {
        return credito;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
}


















