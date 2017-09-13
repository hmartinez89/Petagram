package com.hmartinez.petagram.listaMascotasView;

import com.hmartinez.petagram.adapter.MascotaAdapter;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public interface IListasMascotasView {

    public void setUpActionBar();

    public void generarLinearLayout();

    public MascotaAdapter crearAdaptador(ArrayList<DataSet> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adaptador);
}
