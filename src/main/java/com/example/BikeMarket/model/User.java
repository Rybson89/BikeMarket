package com.example.BikeMarket.model;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    public static ArrayList<User> listOfUsers = new ArrayList<>();

    private ArrayList<Rental> listUsersBikes = new ArrayList<>();
    private String email;
    private String passwrod;
    private int id;

    public User() {
    }

    public User(String email, String passwrod) {
        this.email = email;
        this.passwrod = passwrod;
        this.id = this.hashCode();
    }

    public ArrayList<Rental> getListUsersBikes() {
        return listUsersBikes;
    }

    public void setListUsersBikes(ArrayList<Rental> listUsersBikes) {
        this.listUsersBikes = listUsersBikes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setId() {
        this.id = this.hashCode();
    }

    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(email));
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

    public static boolean isUser(int number){
        if(number<0)
            return false;
        else
            return true;
    }
}
