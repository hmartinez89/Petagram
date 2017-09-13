package com.hmartinez.petagram.db;

import android.content.Context;

import com.hmartinez.petagram.R;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class ConstructorMascotasFavoritas {
    private Context context;

    public ConstructorMascotasFavoritas(Context context) {
        this.context = context;
    }

    public ArrayList<DataSet> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLasMascotasFavoritas();
    }
}
