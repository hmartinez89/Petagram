package com.hmartinez.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hmartinez.petagram.ListaMascotas;
import com.hmartinez.petagram.pojo.Mascota;
import com.hmartinez.petagram.R;
import com.hmartinez.petagram.adapter.MascotaAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<Mascota> alMascotas = ListaMascotas.alMascotas;
    private RecyclerView rvListaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

         rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llmMascotas = new LinearLayoutManager(getActivity());
        llmMascotas.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llmMascotas);

        MascotaAdaptador();
        return v;
    }

    public void MascotaAdaptador(){
        MascotaAdapter adaptador = new MascotaAdapter(alMascotas, getContext());
        rvListaMascotas.setAdapter(adaptador);
    }
}