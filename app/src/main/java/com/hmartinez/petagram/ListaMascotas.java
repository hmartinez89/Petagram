package com.hmartinez.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ListaMascotas extends AppCompatActivity{
    ArrayList<DataSet> alMascotas;
    private RecyclerView rvListaMascotas;

    private Toolbar abListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        abListaMascotas = (Toolbar)findViewById(R.id.tbGeneral);
        setSupportActionBar(abListaMascotas);
        getSupportActionBar().setLogo(R.drawable.icons8_cat_footprint_filled_50);

        rvListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llmMascotas = new LinearLayoutManager(this);
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llmMascotas);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.listamascotas_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.mMascotasFav:
                Collections.sort(alMascotas, DataSet.likesMascotas);

                Intent i = new Intent(this, MascotasFavoritas.class);
                i.putExtra("Mascotas",alMascotas);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(alMascotas, getApplication());
        rvListaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        alMascotas = new ArrayList<DataSet>();

        alMascotas.add(new DataSet("Perrito", "3", R.drawable.perro));
        alMascotas.add(new DataSet("Gatito", R.drawable.gato));
        alMascotas.add(new DataSet("Conejito", "5", R.drawable.conejo));
        alMascotas.add(new DataSet("Pajarito", R.drawable.pajaro));
        alMascotas.add(new DataSet("Koala", R.drawable.koala));
    }
}