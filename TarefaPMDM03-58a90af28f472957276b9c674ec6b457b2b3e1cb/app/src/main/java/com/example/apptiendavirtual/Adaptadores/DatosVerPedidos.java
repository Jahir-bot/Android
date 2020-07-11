package com.example.apptiendavirtual.Adaptadores;

public class DatosVerPedidos {
    private String pedido;
    private String direccion;
    private String nPedido;

    public DatosVerPedidos(String pedido, String direccion, String nPedido) {
        this.pedido = pedido;
        this.direccion = direccion;
        this.nPedido = nPedido;
    }

    public String getPedido() {
        return pedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNPedido() {
        return nPedido;
    }
}
