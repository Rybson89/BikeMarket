package com.example.BikeMarket.storage;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.BikeMarket.controller.BikeMarketController.uploadDirectory;

public class AmazonStorage {


    static AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient() ;
    static String bucket_name = "imagesbikemarket";


    public static String sendPhoto(String key_name, byte[] bytes){
        URL url =null;
        String[] nameArr = key_name.split("\\.");
        String dot = nameArr[nameArr.length-1];

        Path path =null;
        try {
            System.out.println(uploadDirectory+"\\image."+dot);
            path = Files.write(Paths.get(uploadDirectory+"\\image."+dot), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            s3.putObject(bucket_name,key_name, new File(path.toString()));
            url = s3.getUrl(bucket_name,key_name);

        }catch (AmazonServiceException e){
            System.out.println("Nie udało sie wysłąc zdjecia do storage");
        }

        return url.toString();
    }

}
