package com.hmartinez.petagram.pojo;

import java.io.Serializable;
import java.util.Comparator;

public class DataSet implements Serializable{
    private String sNombre;
    private int id, foto, likes ;

    public DataSet(String sNombre, int foto) {
        this.sNombre = sNombre;
        this.foto = foto;
        this.likes = 0;
    }

    public DataSet(String sNombre, int likes, int foto) {
        this.sNombre = sNombre;
        this.foto = foto;
        this.likes = likes;

    }

    public String getsNombre() { return sNombre; }

    public void setsNombre(String sNombre) { this.sNombre = sNombre; }

    public int getFoto() { return foto; }

    public void setFoto(int foto) { this.foto = foto; }

    public int getLikes() { return likes; }

    public void setsLikes(int likes) { this.likes = likes; }

    public static Comparator<DataSet> getLikesMascotas() { return likesMascotas; }

    public static void setLikesMascotas(Comparator<DataSet> likesMascotas) { DataSet.likesMascotas = likesMascotas; }

    public static Comparator<DataSet> likesMascotas = new Comparator<DataSet>() {
        @Override
        public int compare(DataSet o1, DataSet o2) {
            String mascotaLikes1 = Integer.toString(o1.getLikes());
            String mascotaLikes2 = Integer.toString(o2.getLikes());
            return mascotaLikes2.compareTo(mascotaLikes1);
        }
    };
}