package com.android.jahir.appexamenestudioexamen.model;

import android.os.Parcel;
import android.os.Parcelable;

public class concierto implements Parcelable {

    private int id, imagen;
    private String titulo, descripcion, fecha;

    public concierto()
    {

    }

    public concierto(int id, int imagen, String titulo, String descripcion, String fecha) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    protected concierto(Parcel in) {
        id = in.readInt();
        imagen = in.readInt();
        titulo = in.readString();
        descripcion = in.readString();
        fecha = in.readString();
    }

    public static final Creator<concierto> CREATOR = new Creator<concierto>() {
        @Override
        public concierto createFromParcel(Parcel in) {
            return new concierto(in);
        }

        @Override
        public concierto[] newArray(int size) {
            return new concierto[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(imagen);
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeString(fecha);
    }
}
