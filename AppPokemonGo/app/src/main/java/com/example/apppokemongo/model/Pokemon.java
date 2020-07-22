package com.example.apppokemongo.model;


public class Pokemon {

    private int id;
    private String nombre;
    private String url;

    public Pokemon(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public int getId() {
        String[] arrayurl = url.split("/");
        id = Integer.parseInt(arrayurl[arrayurl.length - 1]);
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
