package com.example.BikeMarket.Bikes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.BikeMarket","com.example.BikeMarket.Bikes"})
public class BikesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesApplication.class, args);
	}

}
