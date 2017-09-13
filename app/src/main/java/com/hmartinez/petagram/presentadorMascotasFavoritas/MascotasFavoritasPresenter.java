package com.hmartinez.petagram.presentadorMascotasFavoritas;

import android.content.Context;

import com.hmartinez.petagram.db.ConstructorMascotasFavoritas;
import com.hmartinez.petagram.mascotasFavoritasView.IMascotasFavoritasView;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class MascotasFavoritasPresenter implements IMascotasFavoritasPresenter{

    private IMascotasFavoritasView IMascotasFavoritasView;
    private Context context;
    private ConstructorMascotasFavoritas constructorMascotasFavoritas;
    private ArrayList<DataSet> mascotasFavoritas;

    public MascotasFavoritasPresenter(IMascotasFavoritasView IMascotasFavoritasView, Context context) {
        this.IMascotasFavoritasView = IMascotasFavoritasView;
        this.context = context;
        obtenerMascotasFavoritas();
    }

    @Override
    public void obtenerMascotasFavoritas() {
        constructorMascotasFavoritas = new ConstructorMascotasFavoritas(context);
        mascotasFavoritas = constructorMascotasFavoritas.obtenerDatos();
        mostrarMascotasFavoritasRV();
    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        IMascotasFavoritasView.inicializarAdaptadorRV(IMascotasFavoritasView.crearAdaptador(mascotasFavoritas));
        IMascotasFavoritasView.generarLinearLayout();
    }
}
