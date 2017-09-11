package com.hmartinez.petagram;

import java.io.Serializable;
import java.util.Comparator;

public class DataSet implements Serializable{
    private String sNombre, sLikes;
    private int intFoto;

    public DataSet(String sNombre, int imgFoto) {
        this.sNombre = sNombre;
        this.intFoto = imgFoto;
        this.sLikes = "0";
    }

    public DataSet(String sNombre, String sLikes, int imgFoto) {
        this.sNombre = sNombre;
        this.intFoto = imgFoto;
        this.sLikes = sLikes;

    }

    public String getsNombre() { return sNombre; }

    public void setsNombre(String sNombre) { this.sNombre = sNombre; }

    public int getIntFoto() { return intFoto; }

    public void setIntFoto(int imgFoto) { this.intFoto = imgFoto; }

    public String getsLikes() { return sLikes; }

    public void setsLikes(String sLikes) { this.sLikes = sLikes; }

    public static Comparator<DataSet> getLikesMascotas() { return likesMascotas; }

    public static void setLikesMascotas(Comparator<DataSet> likesMascotas) { DataSet.likesMascotas = likesMascotas; }

    public static Comparator<DataSet> likesMascotas = new Comparator<DataSet>() {
        @Override
        public int compare(DataSet o1, DataSet o2) {
            String mascotaLikes1 = o1.getsLikes();
            String mascotaLikes2 = o2.getsLikes();
            return mascotaLikes2.compareTo(mascotaLikes1);
        }
    };

    public static class MascotaAdapter {
    }
}