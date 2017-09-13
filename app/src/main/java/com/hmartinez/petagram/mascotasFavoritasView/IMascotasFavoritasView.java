package com.hmartinez.petagram.mascotasFavoritasView;

import com.hmartinez.petagram.adapter.MascotaAdapter;
import com.hmartinez.petagram.adapter.MascotasFavoritasAdapter;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public interface IMascotasFavoritasView {

    public void setUpActionBar();

    public void generarLinearLayout();

    public MascotasFavoritasAdapter crearAdaptador(ArrayList<DataSet> mascotas);

    public void inicializarAdaptadorRV(MascotasFavoritasAdapter adaptador);
}
