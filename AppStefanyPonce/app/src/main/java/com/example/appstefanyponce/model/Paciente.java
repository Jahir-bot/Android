package com.example.appstefanyponce.model;

public class Paciente {

    private int codPaciente;
    private String clave;
    private String nombreApellido;
    private String celular;

    public Paciente(int codPaciente, String clave, String nombreApellido, String celular) {
        this.codPaciente = codPaciente;
        this.clave = clave;
        this.nombreApellido = nombreApellido;
        this.celular = celular;
    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }



}
