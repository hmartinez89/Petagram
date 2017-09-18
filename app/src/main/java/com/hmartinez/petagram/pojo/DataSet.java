package com.hmartinez.petagram.pojo;

import java.io.Serializable;
import java.util.Comparator;

public class DataSet implements Serializable{
    private String id, fullName, urlFoto;
    private int likes;

    public DataSet() {    }

    public DataSet(String fullName, String urlFoto) {
        this.fullName = fullName;
        this.urlFoto = urlFoto;
        this.likes = 0;
    }

    public DataSet(String fullName, int likes, String urlFoto) {
        this.fullName = fullName;
        this.urlFoto = urlFoto;
        this.likes = likes;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}