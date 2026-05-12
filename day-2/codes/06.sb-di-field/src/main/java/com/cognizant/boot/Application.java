package com.cognizant.boot;

import java.lang.reflect.Field;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.boot.beans.Car;
import com.cognizant.boot.beans.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		Car carBean = context.getBean(Car.class);
		carBean.startJourney();
		
		Product prod = new Product();
		System.out.println(prod);
		try {
			Class<?> prodClass = Class.forName("com.cognizant.boot.beans.Product");
			Field productIdField = prodClass.getDeclaredField("productId");
			productIdField.setAccessible(true);
			
			productIdField.set(prod, 101);
			System.out.println(prod);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
