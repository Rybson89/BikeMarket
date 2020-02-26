package com.example.BikeMarket.model;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Skuter {
    private String name ;
    private  int price;
    private String imageUrl;
    private int idBike;

    public static List<Skuter> listOfSkuters = new ArrayList<Skuter>();

    static {
//        listOfSkuters.add(new Skuter("Test",69));
//        listOfSkuters.add(new Skuter("Test",69));
//        listOfSkuters.add(new Skuter("Test",69));



    }


    public static List<Skuter> getAllSkuters(){
        return listOfSkuters;
    }


    public Skuter() {
    }

    public Skuter(String name, int price) {
        this.name = name;
        this.price = price;
        this.imageUrl = "";
        this.idBike = this.hashCode();
    }

    public int getIdBike() {
        return idBike;
    }

    public void setIdBike(int idBike) {
        this.idBike = idBike;
    }

    public void setIdBike() {
        this.idBike = this.hashCode();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(name+price));
    }

    @Override
    public String toString() {
        return "Skuter{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", idBike=" + idBike +
                '}';
    }
}
