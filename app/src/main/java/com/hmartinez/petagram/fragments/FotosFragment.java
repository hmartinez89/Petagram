package com.hmartinez.petagram.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hmartinez.petagram.ListaMascotas;
import com.hmartinez.petagram.pojo.Mascota;
import com.hmartinez.petagram.R;
import com.hmartinez.petagram.adapter.CarreteAdapter;

import java.util.ArrayList;

public class FotosFragment extends Fragment{
    private ArrayList<Mascota> alMascotas = ListaMascotas.alMascotas;
    private int intPosition = ListaMascotas.posicion[0];
    private Context context;

    ImageView ivPerfil;
    TextView tvNombreCarrete;
    private RecyclerView rvCarrete;
    GridLayoutManager glmMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListaMascotas.posicion[1] = ListaMascotas.posicion[0];
        View v = inflater.inflate(R.layout.fragment_fotos, container, false);

        ivPerfil = (ImageView)v.findViewById(R.id.ivPerfil_carrete);
        ivPerfil.setImageResource(alMascotas.get(intPosition).getIntFoto());

        tvNombreCarrete = (TextView)v.findViewById(R.id.tvNombreMascota_carrete);
        tvNombreCarrete.setText(alMascotas.get(intPosition).getsNombre());

        rvCarrete = (RecyclerView)v.findViewById(R.id.rvCarrete);

        glmMascotas = new GridLayoutManager(getActivity(),3);
        rvCarrete.setLayoutManager(glmMascotas);

        CarreteAdaptador();
        return v;
    }



    public void CarreteAdaptador(){
        CarreteAdapter adaptador = new CarreteAdapter(alMascotas, getContext(), intPosition);
        rvCarrete.setAdapter(adaptador);
    }
}