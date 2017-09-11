package com.hmartinez.petagram.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hmartinez.petagram.R;

public class ContenedorFragment extends Fragment{

    private static final String TAG = "Contenedor";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View v = inflater.inflate(R.layout.fragment_contenedor, container, false);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.llContenedor, new HomeFragment());
        transaction.commit();
        return v;


    }
}
