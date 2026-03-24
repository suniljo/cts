package com.cognizant.cms;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.services.ContactServices;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private ContactServices contactServices;
	
	public Application(ContactServices contactServices) {
		super();
		this.contactServices = contactServices;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Contact> contacts = contactServices.getAllContactsInOrder();
		contacts.forEach(System.out::println);
	}

}
