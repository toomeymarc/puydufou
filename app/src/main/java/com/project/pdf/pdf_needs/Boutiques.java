package com.project.pdf.pdf_needs;

import android.graphics.drawable.Drawable;

/**
 * Created by Jordan on 15/06/2015.
 */
public class Boutiques {
    int id;
    String name;
    Drawable picture;


    public Boutiques(int id, String name, Drawable picture){
        super();
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    @Override
    public String toString(){
        return id + name + picture;
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

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

}
