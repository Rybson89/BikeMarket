package com.example.BikeMarket.database;

import com.example.BikeMarket.model.Rental;
import com.example.BikeMarket.model.Skuter;
import com.example.BikeMarket.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.BikeMarket.database.Database.polocz;
import static com.example.BikeMarket.database.Database.rozlocz;

public class DataBaseAction {
    public static void sendBike(Skuter skuter){
        polocz();
        String insert = "INSERT INTO automarket(bikeName, price, imageUrl, idbike) VALUES (?, ?, ?, ?)";


        PreparedStatement st;
        try {

            st = Database.connection.prepareStatement(insert) ;
            st.setString(1, skuter.getName());
            st.setInt(2, skuter.getPrice());
            st.setString(3, skuter.getImageUrl());
            st.setInt(4, skuter.getIdBike());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Nie udało sie wpisac playera do bazy");
        }
        rozlocz();
    }

    public static void registerUser(User user){
        polocz();
        String insert = "INSERT INTO Users(IdUser, email, pass) VALUES (?, ?, ?)";
        PreparedStatement st;
        try {

            st = Database.connection.prepareStatement(insert) ;
            st.setInt(1, user.getId());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPasswrod());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Nie udało sie wpisac playera do bazy usera");
        }
        rozlocz();
    }

    public static void upDateBike(Skuter skuter){
        polocz();
        int idBike = skuter.getIdBike();
        String update = "UPDATE automarket SET bikename = ? , price = ? , imageUrl=  ?  WHERE idBike = "+idBike;

        PreparedStatement st;
        try {

            st = Database.connection.prepareStatement(update) ;
            st.setString(1, skuter.getName());
            st.setInt(2, skuter.getPrice());

            st.setString(3, skuter.getImageUrl());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Nie udało zaktualizowac");
        }
        rozlocz();
    }


    public static void upDateRental(Rental rental){
        polocz();
        int idBike = rental.getIdBike();
        String update = "UPDATE Rental SET dateFrom = ? , dateTo = ? , price=  ?  WHERE Idbike = "+idBike;

        PreparedStatement st;
        try {

            st = Database.connection.prepareStatement(update) ;
            st.setString(1, rental.getDateFrom());
            st.setString(2, rental.getDateTo());
            st.setInt(3, rental.getPrice());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Nie udało zaktualizowac");
        }
        rozlocz();
    }

    public static void readFromDataBase(){
        Skuter.getAllSkuters().clear();
        polocz();
        PreparedStatement st;
        try {
            st = Database.connection.prepareStatement("select *from automarket") ;
            ResultSet rs = st.executeQuery();
            String bikeName, imageUrl;
            int price, idBike;
            while (rs.next()){
                bikeName = rs.getString(1);
                price = rs.getInt(2);
                imageUrl = rs.getString(3);
                idBike = rs.getInt(4);


                Skuter skuter = new Skuter(bikeName,price);
                skuter.setImageUrl(imageUrl);
                skuter.setIdBike(idBike);
                Skuter.getAllSkuters().add(skuter);

            }

        } catch (NullPointerException | SQLException ex) {
            System.out.println("Nie mozna odczytać z bazy");
        }
        rozlocz();

    }

    public static boolean login(User user){
        ReadFromDataBase_Users();
        for (User us : User.listOfUsers) {
            if(user.getEmail().equals(us.getEmail()) && user.getPasswrod().equals(us.getPasswrod())){
                return true;
            }
        }
        return false;
    }


    public static void ReadFromDataBase_Users(){
        polocz();
        User.listOfUsers.clear();
        PreparedStatement st;
        try {
            st = Database.connection.prepareStatement("select *from users") ;
            ResultSet rs = st.executeQuery();
            String email, pass;
            int iduser;
            while (rs.next()){
                iduser = rs.getInt(1);
                email = rs.getString(2);
                pass = rs.getString(3);


                User userFromDB = new User(email,pass);
                userFromDB.setId(iduser);
                User.listOfUsers.add(userFromDB);
            }

        } catch (NullPointerException | SQLException ex) {
            System.out.println("Nie mozna odczytać z bazy");
        }
        rozlocz();

    }

    public static void ReadFromDataBase_Rentals(){
        polocz();
        Rental.listOfRentals.clear();
        PreparedStatement st;
        try {
            st = Database.connection.prepareStatement("select *from Rental") ;
            ResultSet rs = st.executeQuery();
            String dateFrom, dateTo;
            int iduser, idBike, price;
            while (rs.next()){
                iduser = rs.getInt(1);
                idBike = rs.getInt(2);
                dateFrom = rs.getString(3);
                dateTo = rs.getString(4);
                price = rs.getInt(5);


                Rental rental = new Rental(iduser,idBike,dateFrom,dateTo,price);
                Rental.listOfRentals.add(rental);
            }

        } catch (NullPointerException | SQLException ex) {
            System.out.println("Nie mozna odczytać z bazy");
        }
        rozlocz();

    }


}
