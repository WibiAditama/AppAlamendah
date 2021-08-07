package com.example.alamendahapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormPemesanan extends AppCompatActivity
{
    private Spinner spinnerMetodePembayaran;
    TextView TotalTiketPesanan,NamaWisata,HargaTiket,TotalHarga;
    EditText NamaPemesan, EmailPemesan, NoHandPhone;
    Button ButtonKonfirmasiPembayaran;
    ImageButton ButtonMinus, ButtonTambah;

    DesaAlamendahApi alamendahApi;
    PostWisata wisata;
    Pembayaran PostPembayaran;
    Pelangggan pelanggan;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pemesanan);

        NamaPemesan = (EditText) findViewById(R.id.NamaPemesan);
        EmailPemesan = (EditText) findViewById(R.id.EmailPemesan);
        NoHandPhone = (EditText) findViewById(R.id.NoHandphonePemesan);
        TotalTiketPesanan = findViewById(R.id.TotalTiketPesanan);
        NamaWisata = findViewById(R.id.WisataPesanan);
        HargaTiket = findViewById(R.id.HargaTiket);
        TotalHarga = findViewById(R.id.TotalHargaTiket);

        ButtonMinus = findViewById(R.id.ButtonMinus);
        ButtonMinus.setOnClickListener(v -> {
            int totalTiketPesanan = Integer.parseInt(TotalTiketPesanan.getText().toString());
            int tiketPesanan = totalTiketPesanan-1;
            String totalTiket = String.valueOf(tiketPesanan);
            TotalTiketPesanan.setText(totalTiket);

            int hargaPajak = 41000;
            Intent intent = getIntent();
            int hargaTiketWisata = intent.getIntExtra(DetailWisata.EXTRA_NUMBER, 0);
            if (tiketPesanan == 0)
            {
                WarningDialog dialog = new WarningDialog();
                dialog.show(getSupportFragmentManager(), "warning dialog");
            }
            else if (hargaTiketWisata != 0)
            {
                int hargaTiket = Integer.parseInt(HargaTiket.getText().toString());
                int HargaTiketWisata = hargaTiket-hargaTiketWisata;
                HargaTiket.setText(String.valueOf(HargaTiketWisata));
                int totalHargaTiket = HargaTiketWisata+hargaPajak;
                TotalHarga.setText(String.valueOf(totalHargaTiket));
            }
        });

        ButtonTambah = findViewById(R.id.ButtonTambah);
        ButtonTambah.setOnClickListener(v -> {
            int totalTiketPesanan = Integer.parseInt(TotalTiketPesanan.getText().toString());
            int tiketPesanan = totalTiketPesanan+1;
            String totalTiket = String.valueOf(tiketPesanan);
            TotalTiketPesanan.setText(totalTiket);

            int hargaPajak = 41000;
            Intent intent = getIntent();
            int hargaWisata = intent.getIntExtra(DetailWisata.EXTRA_NUMBER, 0);
            int hargaTiketWisata = hargaWisata*tiketPesanan;
            HargaTiket.setText(String.valueOf(hargaTiketWisata));
            int totalHargatiket = hargaTiketWisata+hargaPajak;
            TotalHarga.setText(String.valueOf(totalHargatiket));
        });

        spinnerMetodePembayaran = findViewById(R.id.SpinnerMetodePembayaran);
        List<Pembayaran> pembayaran = new ArrayList<>();
        Pembayaran pembayaran1 = new Pembayaran("bank_transfer", "bni");
        pembayaran.add(pembayaran1);
        Pembayaran pembayaran2 = new Pembayaran("bank_transfer", "bri");
        pembayaran.add(pembayaran2);
        Pembayaran pembayaran3 = new Pembayaran("bank_transfer", "permata");
        pembayaran.add(pembayaran3);
        Pembayaran pembayaran4 = new Pembayaran("echannel", "mandiri");
        pembayaran.add(pembayaran4);
        Pembayaran pembayaran5 = new Pembayaran("gopay", "gopay");
        pembayaran.add(pembayaran5);
        Pembayaran pembayaran6 = new Pembayaran("shopeepay", "shopeepay");
        pembayaran.add(pembayaran6);

        ArrayAdapter<Pembayaran> adapter = new ArrayAdapter<Pembayaran>(this,
                android.R.layout.simple_spinner_item, pembayaran);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMetodePembayaran.setAdapter(adapter);

        int hargaPajak = 41000;
        Intent intent = getIntent();
        String namaWisata = intent.getStringExtra(DetailWisata.EXTRA_TEXT);
        int hargaWisata = intent.getIntExtra(DetailWisata.EXTRA_NUMBER, 0);
        int intentId = intent.getIntExtra(DetailWisata.EXTRA_NUMBER2, 0);
        NamaWisata.setText(namaWisata);
        HargaTiket.setText(String.valueOf(hargaWisata));
        int totalHargaTiketWisata = hargaWisata+hargaPajak;
        TotalHarga.setText(String.valueOf(totalHargaTiketWisata));

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://desaalamendah.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        alamendahApi = retrofit.create(DesaAlamendahApi.class);
        int TotalTiket = Integer.parseInt(TotalTiketPesanan.getText().toString());
        wisata = new PostWisata(intentId, TotalTiket);
        PostPembayaran = (Pembayaran) spinnerMetodePembayaran.getSelectedItem();

        ButtonKonfirmasiPembayaran = findViewById(R.id.ButtonKonfirmasiPembayaran);
        ButtonKonfirmasiPembayaran.setOnClickListener(v -> {
            String nama = NamaPemesan.getText().toString();
            String email = EmailPemesan.getText().toString();
            String handphone = NoHandPhone.getText().toString();
            pelanggan = new Pelangggan(nama, email, handphone);

            ObjectPembayaran objectPembayaran = new ObjectPembayaran(wisata, PostPembayaran, pelanggan);
            Call<ObjectPembayaran> call = alamendahApi.getResponse(objectPembayaran);
            call.enqueue(new Callback<ObjectPembayaran>() {
                @Override
                public void onResponse(Call<ObjectPembayaran> call, Response<ObjectPembayaran> response) {
                    if (!response.isSuccessful())
                    {
                        Toast.makeText(FormPemesanan.this, "Code: "+response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ObjectPembayaran responsePembayaran = response.body();
                    Toast.makeText(FormPemesanan.this, "Detail: " + response.body(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<ObjectPembayaran> call, Throwable t) {
                    Log.d("response", ""+t.getMessage());
                }
            });
        });
    }
}
