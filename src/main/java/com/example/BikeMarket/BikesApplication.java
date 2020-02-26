package com.example.BikeMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.BikeMarket","com.example.BikeMarket.controller","com.example.BikeMarket.database","com.example.BikeMarket.model","com.example.BikeMarket.storage"})
public class BikesApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BikesApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BikesApplication.class, args);
	}




}
