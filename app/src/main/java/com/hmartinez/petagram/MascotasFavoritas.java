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

        Toolbar abMascotasFav = (Toolbar) findViewById(R.id.abMascotasFav);
        setSupportActionBar(abMascotasFav);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = this.getIntent().getExtras();
        Mascota[] aMascotasFav = new Mascota[(int) extras.get(String.valueOf(R.string.totalMascotasFav_param))];

    }
}
