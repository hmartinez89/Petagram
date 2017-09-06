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

public class ListaMascotas extends AppCompatActivity{

    private Toolbar abListaMascotas;
    private TabLayout tlListaMascotas;
    private ViewPager vpListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        abListaMascotas = (Toolbar)findViewById(R.id.tbGeneral);
        setSupportActionBar(abListaMascotas);

        tlListaMascotas = (TabLayout)findViewById(R.id.tlListaMascotas);
        vpListaMascotas = (ViewPager)findViewById(R.id.vpListaMascotas);
        setUpViewPager();/**/
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
}