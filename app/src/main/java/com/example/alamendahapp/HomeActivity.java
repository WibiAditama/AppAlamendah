package com.example.alamendahapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    ConstraintLayout CoffeeTrip, Ngagoes, AlamendahTrip;

    public static final String EXTRA_NUMBER = "com.example.alamendah.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CoffeeTrip = findViewById(R.id.CoffeeTrip);
        CoffeeTrip.setOnClickListener(v -> openCoffeeTripActivity());
        Ngagoes = findViewById(R.id.Ngagoes);
        Ngagoes.setOnClickListener(v -> openNgagoesActivity());
        AlamendahTrip = findViewById(R.id.AlamendahTrip);
        AlamendahTrip.setOnClickListener(v -> openAlamendahTripActivity());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.alamendah_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.ProfileDesa:
                Intent intentProfileDesa = new Intent(this, ProfileDesa.class);
                startActivity(intentProfileDesa);
                return true;
            case R.id.Gallery:
                Intent intentGallery = new Intent(this, GalleryActivity.class);
                startActivity(intentGallery);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openCoffeeTripActivity()
    {
        Intent intent = new Intent(this, DetailWisata.class);
        intent.putExtra(EXTRA_NUMBER, 6);
        startActivity(intent);
    }

    public void openNgagoesActivity()
    {
        Intent intent = new Intent(this, DetailWisata.class);
        intent.putExtra(EXTRA_NUMBER, 5);
        startActivity(intent);
    }

    public void openAlamendahTripActivity()
    {
        Intent intent = new Intent(this, DetailWisata.class);
        intent.putExtra(EXTRA_NUMBER, 7);
        startActivity(intent);
    }
}
