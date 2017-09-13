package com.hmartinez.petagram.db;

import android.content.Context;

import com.hmartinez.petagram.R;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<DataSet> obtenerDatos(){
        ArrayList<DataSet> alMascotas = new ArrayList<DataSet>();

        alMascotas.add(new DataSet("Perrito", 3, R.drawable.perro));
        alMascotas.add(new DataSet("Gatito", R.drawable.gato));
        alMascotas.add(new DataSet("Conejito", 5, R.drawable.conejo));
        alMascotas.add(new DataSet("Pajarito", R.drawable.pajaro));
        alMascotas.add(new DataSet("Koala", R.drawable.koala));

        return alMascotas;
    }
}
