package com.hmartinez.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    ArrayList<DataSet> alMascotas;
    private RecyclerView rvMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar abMascotasFav = (Toolbar) findViewById(R.id.tbGeneral);
        setSupportActionBar(abMascotasFav);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = this.getIntent().getExtras();
        alMascotas = (ArrayList<DataSet>) extras.get("Mascotas");

        rvMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager llmMascotas = new LinearLayoutManager(this);
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFav.setLayoutManager(llmMascotas);

        inicializarAdaptador();
    }
    public void inicializarAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(alMascotas, getApplication());
        rvMascotasFav.setAdapter(adaptador);
    }
}
