package com.example.alamendahapp;

public class DataGambar {

    //model class for Gambar data
    private int id;
    private String url;
    private String isGallery;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;

    //getters
    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getIsGallery() {
        return isGallery;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    //constructor
    public DataGambar(int id, String url, String isGallery, String createdAt, String updatedAt, String deletedAt) {
        this.id = id;
        this.url = url;
        this.isGallery = isGallery;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
}
