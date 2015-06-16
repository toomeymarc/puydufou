package com.project.pdf.pdf_needs;

import android.graphics.drawable.Drawable;

/**
 * Created by Jordan on 15/06/2015.
 */
public class Spectacles {

    int id;
    String name;
    String debut;
    String duree;
    Drawable picture;



    public Spectacles(int id, String name, String debut, String duree, Drawable picture) {
        super();
        this.id = id;
        this.name = name;
        this.debut = debut;
        this.duree = duree;
        this.picture = picture;
    }


    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return id + name + debut + duree + picture;
    }
}
