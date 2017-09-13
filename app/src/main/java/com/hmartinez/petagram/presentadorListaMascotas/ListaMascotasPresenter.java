package com.hmartinez.petagram.presentadorListaMascotas;

import android.content.Context;

import com.hmartinez.petagram.db.ConstructorMascotas;
import com.hmartinez.petagram.listaMascotasView.IListasMascotasView;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class ListaMascotasPresenter implements IListaMascotasPresenter{

    private IListasMascotasView IListaMascotasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<DataSet> mascotas;

    public ListaMascotasPresenter(IListasMascotasView IListaMascotasView, Context context) {
        this.IListaMascotasView = IListaMascotasView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        IListaMascotasView.inicializarAdaptadorRV(IListaMascotasView.crearAdaptador(mascotas));
        IListaMascotasView.generarLinearLayout();
    }
}
