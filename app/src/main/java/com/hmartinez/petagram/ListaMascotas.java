package com.hmartinez.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ListaMascotas extends AppCompatActivity{
    ArrayList<Mascota> alMascotas;
    private RecyclerView rvListaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        Toolbar abListaMascotas = (Toolbar)findViewById(R.id.abListaMascotas);
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
                Collections.sort(alMascotas, Mascota.likesMascotas);

                Intent i = new Intent(this, MascotasFavoritas.class);
                int n=0;
                while(n<5 && alMascotas.get(n).getsLikes()!="0"){
                    i.putExtra(String.format(getResources().getString(R.string.mascotasFav_param),n),alMascotas.get(n));
                    n++;
                }
                i.putExtra(String.valueOf(R.string.totalMascotasFav_param), n);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(alMascotas);
        rvListaMascotas.setAdapter(adaptador);
    }
    
    public void inicializarListaMascotas(){
        alMascotas = new ArrayList<Mascota>();

        alMascotas.add(new Mascota("Perrito", "3", R.drawable.perro));
        alMascotas.add(new Mascota("Gatito", R.drawable.gato));
        alMascotas.add(new Mascota("Conejito", "5", R.drawable.conejo));
        alMascotas.add(new Mascota("Pajarito", R.drawable.pajaro));
        alMascotas.add(new Mascota("Koala", R.drawable.koala));
    }
}