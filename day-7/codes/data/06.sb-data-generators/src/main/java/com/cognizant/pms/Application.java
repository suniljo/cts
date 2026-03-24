package com.cognizant.pms;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.pms.entities.Product;
import com.cognizant.pms.repositories.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class Application {
	@Autowired
	private ProductRepository productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@PostConstruct
	public void initializeData() {
		Product prod1 = new Product("Mobile", 65000.5f);
		Product prod2 = new Product("Charger", 250f);
		Product prod3 = new Product("Laptop", 75000.5f);
		Product prod4 = new Product("Desktop", 42500.5f);
		
		List<Product> products = Arrays.asList(prod1, prod2, prod3, prod4);
		
		productRepo.saveAll(products);		
	}
}
