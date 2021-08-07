package com.example.alamendahapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailWisata extends AppCompatActivity {
    TextView NamaWisata, HargaWisata, DeskripsiWisata, Fasilitas1, Fasilitas2, Fasilitas3, Fasilitas4, Fasilitas5,
            Fasilitas6, Fasilitas7, Fasilitas8;
    ImageView ImgWisata, ButtonBack;
    Button ButtonPesan;

    int intentId;

    public static final String EXTRA_TEXT = "com.example.alamendah.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.alamendah.EXTRA_NUMBER";
    public static final String EXTRA_NUMBER2 = "com.example.alamendah.EXTRA_NUMBER2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        ButtonBack = findViewById(R.id.ButtonBack);
        ButtonBack.setOnClickListener(v -> backToHome());

        NamaWisata = findViewById(R.id.NamaWisata);
        HargaWisata = findViewById(R.id.HargaWisata);
        DeskripsiWisata = findViewById(R.id.DeskripsiWisata);
        Fasilitas1 = findViewById(R.id.Fasilitas1);
        Fasilitas2 = findViewById(R.id.Fasilitas2);
        Fasilitas3 = findViewById(R.id.Fasilitas3);
        Fasilitas4 = findViewById(R.id.Fasilitas4);
        Fasilitas5 = findViewById(R.id.Fasilitas5);
        Fasilitas6 = findViewById(R.id.Fasilitas6);
        Fasilitas7 = findViewById(R.id.Fasilitas7);
        Fasilitas8 = findViewById(R.id.Fasilitas8);
        ImgWisata = findViewById(R.id.ImgWisata);

        Intent intentid = getIntent();
        intentId = intentid.getIntExtra(HomeActivity.EXTRA_NUMBER, 0);

        ButtonPesan = findViewById(R.id.ButtonPesan);
        ButtonPesan.setOnClickListener(v -> {
            String namaWisata = NamaWisata.getText().toString();
            int hargaWisata = Integer.parseInt(HargaWisata.getText().toString());
            Intent intent = new Intent(this, FormPemesanan.class);
            intent.putExtra(EXTRA_TEXT,namaWisata);
            intent.putExtra(EXTRA_NUMBER, hargaWisata);
            intent.putExtra(EXTRA_NUMBER2, intentId);
            startActivity(intent);
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://desaalamendah.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DesaAlamendahApi alamendahApi = retrofit.create(DesaAlamendahApi.class);
        Call<DataWisata> call = alamendahApi.getWisata(intentId);
        call.enqueue(new Callback<DataWisata>() {
            @Override
            public void onResponse(Call<DataWisata> call, Response<DataWisata> response) {
                if (!response.isSuccessful())
                {
                    DeskripsiWisata.setText("Code: "+response.code());
                    return;
                }
                DataWisata dataWisata = response.body();
                Wisata wisata = dataWisata.getData();
                String nama = wisata.getNama();
                int harga = wisata.getHarga();
                String deskripsi = wisata.getDeskripsi();
                String fasilitas = wisata.getFasilitas();
                List<String> listFasilitas = new ArrayList<String>(Arrays.asList(fasilitas.split(",")));

                NamaWisata.setText(nama);
                HargaWisata.setText(String.valueOf(harga));

                Picasso.get()
                        .load(dataWisata.getData().getGambar().getUrl())
                        .into(ImgWisata);

                if (wisata.getDeskripsi() == null)
                {
                    String noDesk = "Belum ada deskripsi lebih lanjut.";
                    DeskripsiWisata.setText(noDesk);
                }
                else {
                    DeskripsiWisata.setText(deskripsi);
                }
                Fasilitas1.setText(listFasilitas.get(0));
                Fasilitas2.setText(listFasilitas.get(1));
                Fasilitas3.setText(listFasilitas.get(2));
                Fasilitas4.setText(listFasilitas.get(3));
                Fasilitas5.setText(listFasilitas.get(4));
                Fasilitas6.setText(listFasilitas.get(5));
                Fasilitas7.setText(listFasilitas.get(6));
                if (listFasilitas.size() > 7)
                {
                    Fasilitas8.setText(listFasilitas.get(7));
                }
                else {
                    Fasilitas8.setText(" ");
                }
            }

            @Override
            public void onFailure(Call<DataWisata> call, Throwable t) {
                DeskripsiWisata.setText(t.getMessage());
            }
        });
    }

    private void backToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
