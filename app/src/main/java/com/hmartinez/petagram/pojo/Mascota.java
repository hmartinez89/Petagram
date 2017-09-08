package com.hmartinez.petagram.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Mascota implements Serializable{
    private String sNombre, sLikes;
    private int intFoto;
    private ArrayList<Integer> alCarrete = new ArrayList<>();
    private ArrayList<String> alLikesCarrete = new ArrayList<>();

    public Mascota(String sNombre, int imgFoto) {
        this.sNombre = sNombre;
        this.intFoto = imgFoto;
        this.sLikes = "0";
    }

    public Mascota(String sNombre, String sLikes, int imgFoto, ArrayList<Integer> alCarrete, ArrayList<String> alLikesCarrete) {
        this.sNombre = sNombre;
        this.intFoto = imgFoto;
        this.sLikes = sLikes;
        this.alCarrete = alCarrete;
        this.alLikesCarrete = alLikesCarrete;
    }
    public String getsNombre() { return sNombre; }

    public void setsNombre(String sNombre) { this.sNombre = sNombre; }

    public int getIntFoto() { return intFoto; }

    public void setIntFoto(int imgFoto) { this.intFoto = imgFoto; }

    public String getsLikes() { return sLikes; }

    public void setsLikes(String sLikes) { this.sLikes = sLikes; }

    public ArrayList<Integer> getAlCarrete() { return alCarrete; }

    public void setAlCarrete(ArrayList<Integer> alCarrete) { this.alCarrete = alCarrete; }

    public ArrayList<String> getAlLikesCarrete(){ return alLikesCarrete; }

    public void setAlLikesCarrete(ArrayList<String> alLikesCarrete) { this.alLikesCarrete = alLikesCarrete; }

    public static Comparator<Mascota> getLikesMascotas() { return likesMascotas; }

    public static void setLikesMascotas(Comparator<Mascota> likesMascotas) { Mascota.likesMascotas = likesMascotas; }

    public static Comparator<Mascota> likesMascotas = new Comparator<Mascota>() {
        @Override
        public int compare(Mascota o1, Mascota o2) {
            String mascotaLikes1 = o1.getsLikes();
            String mascotaLikes2 = o2.getsLikes();
            return mascotaLikes2.compareTo(mascotaLikes1);
        }
    };
}