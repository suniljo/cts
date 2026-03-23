package com.cognizant.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "L M S",
								version = "2.0",
								description = "Library Management System",
							    contact = @Contact(name = "Sunil Joseph", email = "sunil.j@example.com")))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
