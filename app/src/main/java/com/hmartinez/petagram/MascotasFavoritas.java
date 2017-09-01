package com.hmartinez.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MascotasFavoritas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
