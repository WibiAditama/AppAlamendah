package com.example.alamendahapp;

public class Wisata {

    private int id;
    private String nama;
    private int harga;
    private int gambarid;
    private String deskripsi;
    private boolean paketan;
    private String fasilitas;
    private int totalTiket;
    private int minTiket;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;

    //make object of class Gambar
    private DataGambar Gambar;

    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getGambarid() {
        return gambarid;
    }

    public void setGambarid(int gambarid) {
        this.gambarid = gambarid;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public boolean isPaketan() {
        return paketan;
    }

    public void setPaketan(boolean paketan) {
        this.paketan = paketan;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public int getTotalTiket() {
        return totalTiket;
    }

    public void setTotalTiket(int totalTiket) {
        this.totalTiket = totalTiket;
    }

    public int getMinTiket() {
        return minTiket;
    }

    public void setMinTiket(int minTiket) {
        this.minTiket = minTiket;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public DataGambar getGambar() {
        return Gambar;
    }

    public void setGambar(DataGambar gambar) {
        Gambar = gambar;
    }

    //constructor
    public Wisata(int id, String nama, int harga, int gambarid, String deskripsi, boolean paketan, String fasilitas, int totalTiket, int minTiket, String createdAt, String updatedAt, String deletedAt, DataGambar gambar) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.gambarid = gambarid;
        this.deskripsi = deskripsi;
        this.paketan = paketan;
        this.fasilitas = fasilitas;
        this.totalTiket = totalTiket;
        this.minTiket = minTiket;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        Gambar = gambar;
    }
}
