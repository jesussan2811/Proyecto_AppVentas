package com.example.appventas.entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ModeloClientes implements Serializable {
    private int CLIID;
    private String CLINOMBRE;
    private String APELLIDOS;
    private double CREDITO;
    private String TELEFONO;
    private String DOMICILIO;
    private String FECHANACIMIENTO;

    public ModeloClientes(){}

    public ModeloClientes(int cliID, String cliNombre, String apellido, double credito, String telefono, String domicilio, String fechaNacimiento){
        this.CLIID = cliID;
        this.CLINOMBRE = cliNombre;
        this.APELLIDOS = apellido;
        this.CREDITO = credito;
        this.TELEFONO = telefono;
        this.DOMICILIO = domicilio;
        this.FECHANACIMIENTO = fechaNacimiento;
    }
    public ModeloClientes(String cliNombre, String apellido, double credito, String telefono, String domicilio, String fechaNacimiento){
        this.CLINOMBRE = cliNombre;
        this.APELLIDOS = apellido;
        this.CREDITO = credito;
        this.TELEFONO = telefono;
        this.DOMICILIO = domicilio;
        this.FECHANACIMIENTO = fechaNacimiento;
    }

    public int getCliID() {
        return CLIID;
    }

    public String getCliNombre() {
        return CLINOMBRE;
    }

    public String getApellido() {
        return APELLIDOS;
    }

    public double getCredito() {
        return CREDITO;
    }

    public String getTelefono() {
        return TELEFONO;
    }

    public String getDomicilio() {
        return DOMICILIO;
    }

    public String getFechaNacimiento() {
        return FECHANACIMIENTO;
    }
}


















