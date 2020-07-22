package com.example.appstefanyponce.model;

import android.view.Display;

public class Modelo {

    private int albumId;
    private int id;
    private String title;
    private String thumbnailUrl;

    public Modelo ()
    {

    }

    public Modelo(int albumId, int id, String title, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
