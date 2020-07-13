package com.example.appjahirsanroman;

public class Alumno {

    private String codigo;
    private String password;
    private String nomApellido;
    private String especialidad;
    private String ciclo;

    public Alumno()
    {

    }

    public Alumno(String codigo, String password, String nomApellido, String especialidad, String ciclo) {
        this.codigo = codigo;
        this.password = password;
        this.nomApellido = nomApellido;
        this.especialidad = especialidad;
        this.ciclo = ciclo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomApellido() {
        return nomApellido;
    }

    public void setNomApellido(String nomApellido) {
        this.nomApellido = nomApellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
}
