package com.example.alamendahapp;

public class Pelangggan {
    private String nama;
    private String email;
    private String handphone;

    public Pelangggan(String nama, String email, String handphone) {
        this.nama = nama;
        this.email = email;
        this.handphone = handphone;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }
}
