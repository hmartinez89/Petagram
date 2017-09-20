package com.hmartinez.petagram.restAPI.model;

import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class MascotaResponse {
    ArrayList<DataSet> mascotas;

    public ArrayList<DataSet> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<DataSet> mascotas) {
        this.mascotas = mascotas;
    }
}
