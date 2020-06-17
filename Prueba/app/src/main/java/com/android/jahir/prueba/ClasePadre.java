package com.android.jahir.prueba;

public class ClasePadre {

    private String nombre;
    private String apellido;
    private Integer edad;

   public ClasePadre()
   {
   }

    public ClasePadre(String nombre, String apellido, Integer edad) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
