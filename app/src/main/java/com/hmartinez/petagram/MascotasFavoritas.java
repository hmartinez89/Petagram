package com.hmartinez.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MascotasFavoritas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar abMascotasFav = (Toolbar) findViewById(R.id.tbGeneral);
        setSupportActionBar(abMascotasFav);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
