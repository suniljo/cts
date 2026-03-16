package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.boot.beans.DBConnection;
import com.cognizant.boot.beans.Product;
import com.cognizant.boot.beans.Ticket;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		Ticket tkt = context.getBean(Ticket.class);
		System.out.println(tkt);
		
		System.out.println();
		DBConnection dbCon = context.getBean(DBConnection.class);
		System.out.println(dbCon);
		
		Product prod = Product.builder()
							  .productId(1001)
							  .productName("Mobile")
							  .productPrice(25000f)
							  .build();
		System.out.println(prod);							  
	}
}
