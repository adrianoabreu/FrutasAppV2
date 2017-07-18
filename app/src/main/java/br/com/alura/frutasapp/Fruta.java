package br.com.alura.frutasapp;

import java.io.Serializable;

/**
 * Created by user on 14/07/2017.
 */

class Fruta implements Serializable{

    private String name;
    private String image;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
