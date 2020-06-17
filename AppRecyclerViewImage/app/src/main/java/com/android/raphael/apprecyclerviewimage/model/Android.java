package com.android.raphael.apprecyclerviewimage.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Android implements Parcelable{

    private int id, imagen;
    private String nombre, version;

    public Android() {

    }

    public Android(int id, int imagen, String nombre, String version) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.version = version;
    }

    protected Android(Parcel in) {
        id = in.readInt();
        imagen = in.readInt();
        nombre = in.readString();
        version = in.readString();
    }

    public static final Creator<Android> CREATOR = new Creator<Android>() {
        @Override
        public Android createFromParcel(Parcel in) {
            return new Android(in);
        }

        @Override
        public Android[] newArray(int size) {
            return new Android[size];
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(imagen);
        dest.writeString(nombre);
        dest.writeString(version);
    }
}
