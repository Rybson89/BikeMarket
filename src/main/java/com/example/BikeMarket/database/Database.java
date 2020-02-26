package com.example.BikeMarket.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static Statement statement;
    public static Connection connection;
    public static void polocz(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://mytestdatabase.cd5sl8ldadft.eu-central-1.rds.amazonaws.com:6378/postgres","postgres","random.3");
            statement = connection.createStatement();
        }catch (ClassNotFoundException | SQLException e ){
            e.printStackTrace();
        }

    }
    public static void rozlocz(){
        try {
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
