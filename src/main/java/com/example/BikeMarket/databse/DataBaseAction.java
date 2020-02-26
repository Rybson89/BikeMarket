package com.example.BikeMarket.databse;

import com.example.BikeMarket.model.Skuter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.BikeMarket.databse.Database.polocz;
import static com.example.BikeMarket.databse.Database.rozlocz;

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


}
