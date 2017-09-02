package com.hmartinez.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {
    ArrayList<Mascota> alMascotas;
    private RecyclerView rvListaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        Toolbar tbPetagram = (Toolbar) findViewById(R.id.tbPetagram);
        setSupportActionBar(tbPetagram);

        rvListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llmMascotas = new LinearLayoutManager(this);
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llmMascotas);

        inicializarListaMascotas();
        inicializarAdaptador();

    }
    public void inicializarAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(alMascotas);
        rvListaMascotas.setAdapter(adaptador);
    }
    
    public void inicializarListaMascotas(){
        alMascotas = new ArrayList<Mascota>();

        alMascotas.add(new Mascota("Perrito", R.drawable.perro));
        alMascotas.add(new Mascota("Gatito", R.drawable.gato));
        alMascotas.add(new Mascota("Conejito", R.drawable.conejo));
        alMascotas.add(new Mascota("Pajarito", R.drawable.pajaro));
        alMascotas.add(new Mascota("Koala", R.drawable.koala));
    }
}