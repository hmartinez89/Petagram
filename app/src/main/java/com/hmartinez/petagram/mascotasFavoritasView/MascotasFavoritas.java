package com.hmartinez.petagram.mascotasFavoritasView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.hmartinez.petagram.R;
import com.hmartinez.petagram.adapter.MascotaAdapter;
import com.hmartinez.petagram.adapter.MascotasFavoritasAdapter;
import com.hmartinez.petagram.db.ConstructorMascotasFavoritas;
import com.hmartinez.petagram.pojo.DataSet;
import com.hmartinez.petagram.presentadorMascotasFavoritas.IMascotasFavoritasPresenter;
import com.hmartinez.petagram.presentadorMascotasFavoritas.MascotasFavoritasPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IMascotasFavoritasView {
    ArrayList<DataSet> alMascotas;
    private RecyclerView rvMascotasFav;
    private IMascotasFavoritasPresenter presenter;
    private Toolbar abMascotasFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        abMascotasFav = (Toolbar) findViewById(R.id.tbGeneral);
        setUpActionBar();

        rvMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        presenter = new MascotasFavoritasPresenter(this, getApplicationContext());
    }

    @Override
    public void setUpActionBar(){
        setSupportActionBar(abMascotasFav);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void generarLinearLayout() {
        LinearLayoutManager llmMascotas = new LinearLayoutManager(this);
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFav.setLayoutManager(llmMascotas);
    }

    @Override
    public MascotasFavoritasAdapter crearAdaptador(ArrayList<DataSet> mascotas) {
        MascotasFavoritasAdapter adaptador = new MascotasFavoritasAdapter(mascotas, getApplicationContext());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasFavoritasAdapter adaptador) {
        rvMascotasFav.setAdapter(adaptador);
    }
}
