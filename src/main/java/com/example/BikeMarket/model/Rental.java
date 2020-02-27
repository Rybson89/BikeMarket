package com.example.BikeMarket.model;

import java.util.ArrayList;

public class Rental {
    private int idUser;
    private int idBike;
    private String dateFrom;
    private String dateTo;
    private int price;

    public static ArrayList<Rental> listOfRentals = new ArrayList<>();


    public Rental() {
    }

    public Rental(int idUser, int idBike, String dateFrom, String dateTo, int price) {
        this.idUser = idUser;
        this.idBike = idBike;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBike() {
        return idBike;
    }

    public void setIdBike(int idBike) {
        this.idBike = idBike;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Rental{" +
                "idUser=" + idUser +
                ", idBike=" + idBike +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", price=" + price +
                '}';
    }
}
