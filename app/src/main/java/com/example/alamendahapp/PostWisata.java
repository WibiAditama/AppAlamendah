package com.example.alamendahapp;

public class PostWisata {
    private int id;
    private int tiket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTiket() {
        return tiket;
    }

    public void setTiket(int tiket) {
        this.tiket = tiket;
    }

    public PostWisata(int id, int tiket) {
        this.id = id;
        this.tiket = tiket;
    }
}
