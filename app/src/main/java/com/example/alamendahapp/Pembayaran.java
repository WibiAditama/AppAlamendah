package com.example.alamendahapp;

import androidx.annotation.NonNull;

public class Pembayaran {
    private String tipe_pembayaran;
    private String metode_pembayaran;

    public Pembayaran(String tipe_pembayaran, String metode_pembayaran) {
        this.tipe_pembayaran = tipe_pembayaran;
        this.metode_pembayaran = metode_pembayaran;
    }

    public String getTipe_pembayaran() {
        return tipe_pembayaran;
    }

    public void setTipe_pembayaran(String tipe_pembayaran) {
        this.tipe_pembayaran = tipe_pembayaran;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    @NonNull
    @Override
    public String toString() {
        return metode_pembayaran;
    }
}
