package com.hmartinez.petagram.listaMascotasView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hmartinez.petagram.pojo.DataSet;
import com.hmartinez.petagram.adapter.MascotaAdapter;
import com.hmartinez.petagram.mascotasFavoritasView.MascotasFavoritas;
import com.hmartinez.petagram.R;
import com.hmartinez.petagram.presentadorListaMascotas.IListaMascotasPresenter;
import com.hmartinez.petagram.presentadorListaMascotas.ListaMascotasPresenter;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity implements IListasMascotasView{
    private RecyclerView rvListaMascotas;
    private IListaMascotasPresenter presenter;
    private Toolbar abListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        abListaMascotas = (Toolbar)findViewById(R.id.tbGeneral);
        setUpActionBar();

        rvListaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        presenter = new ListaMascotasPresenter(this, getApplicationContext());
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.listamascotas_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){
            case R.id.mMascotasFav:
                Intent i = new Intent(this, MascotasFavoritas.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUpActionBar(){
        setSupportActionBar(abListaMascotas);
        getSupportActionBar().setLogo(R.drawable.icons8_cat_footprint_filled_50);
    }

    @Override
    public void generarLinearLayout() {
        LinearLayoutManager llmMascotas = new LinearLayoutManager(this);
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llmMascotas);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<DataSet> mascotas) {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, getApplicationContext());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {
        rvListaMascotas.setAdapter(adaptador);
    }
}