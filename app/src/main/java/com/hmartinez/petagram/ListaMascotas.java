package com.hmartinez.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hmartinez.petagram.adapter.PageAdapter;
import com.hmartinez.petagram.fragments.FotosFragment;
import com.hmartinez.petagram.fragments.HomeFragment;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    public static ArrayList<Mascota> alMascotas;
    private Toolbar abListaMascotas;
    private TabLayout tlListaMascotas;
    private ViewPager vpListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inicializarListaMascotas();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        abListaMascotas = (Toolbar)findViewById(R.id.tbGeneral);
        setSupportActionBar(abListaMascotas);

        tlListaMascotas = (TabLayout)findViewById(R.id.tlListaMascotas);
        vpListaMascotas = (ViewPager)findViewById(R.id.vpListaMascotas);
        setUpViewPager();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.listamascotas_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent i;
        switch(item.getItemId()){
            case R.id.mMascotasFav:
                i = new Intent(this, MascotasFavoritas.class);
                startActivity(i);
                break;

            case R.id.mContacto:
                i = new Intent(this, Contacto.class);
                startActivity(i);
                break;

            case R.id.mAbout:
                i = new Intent(this, About.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment> fragmentos = new ArrayList<>();

        fragmentos.add(new HomeFragment());
        fragmentos.add(new FotosFragment());

        return fragmentos;
    }
    private void setUpViewPager(){
        vpListaMascotas.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tlListaMascotas.setupWithViewPager(vpListaMascotas);

        tlListaMascotas.getTabAt(0).setIcon(R.mipmap.ic_tabhome);
        tlListaMascotas.getTabAt(1).setIcon(R.mipmap.ic_rollo);
    }

    public void inicializarListaMascotas(){
        alMascotas = new ArrayList<Mascota>();

        ArrayList<String> alLikesCarrete = new ArrayList<String>();
        ArrayList<Integer> alCarrete = new ArrayList<Integer>();
        for(int j=0; j<5; j++){
            alLikesCarrete.add(Integer.toString(j+1));
            alCarrete.add(R.drawable.perro);
        }
        alMascotas.add(new Mascota("Perrito", "3", R.drawable.perro, alCarrete, alLikesCarrete));

        alMascotas.add(new Mascota("Gatito", R.drawable.gato));

        alLikesCarrete = new ArrayList<String>();
        alCarrete = new ArrayList<Integer>();
        for (int j=0; j<7; j++){
            alLikesCarrete.add(Integer.toString(7-j));
            alCarrete.add(R.drawable.conejo);
        }
        alMascotas.add(new Mascota("Conejito", "5", R.drawable.conejo, alCarrete, alLikesCarrete));

        alMascotas.add(new Mascota("Pajarito", R.drawable.pajaro));
        alMascotas.add(new Mascota("Koala", R.drawable.koala));
    }
}