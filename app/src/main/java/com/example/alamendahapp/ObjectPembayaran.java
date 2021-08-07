package com.example.alamendahapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectPembayaran {
    private PostWisata wisata;
    private Pembayaran pembayaran;
    @SerializedName("pelanggan")
    private Pelangggan pelangggan;

    public ObjectPembayaran(PostWisata wisata, Pembayaran pembayaran, Pelangggan pelangggan) {
        this.wisata = wisata;
        this.pembayaran = pembayaran;
        this.pelangggan = pelangggan;
    }

    public PostWisata getWisata() {
        return wisata;
    }

    public void setWisata(PostWisata wisata) {
        this.wisata = wisata;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public Pelangggan getPelangggan() {
        return pelangggan;
    }

    public void setPelangggan(Pelangggan pelangggan) {
        this.pelangggan = pelangggan;
    }
}
