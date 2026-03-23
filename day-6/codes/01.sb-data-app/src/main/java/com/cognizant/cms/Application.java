package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		//get reference of repository
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		/*
		* ContactRepository is an interface - then how come instance/bean? 
		* - uses Proxy Design Pattern- implementation class is being created internally
		*/
		
		System.out.println("implementation class of repository interface = " + contactRepo.getClass().getName());
		System.out.println();
		
		/*
		//--save a contact
		Contact contact = new Contact();
		contact.setContactId(101);
		contact.setContactName("Sanjay Patil");
		contact.setContactNumber(9848586878L);
		
		contactRepo.save(contact);
		Contact savedContact = contactRepo.save(contact);
		*/
		
		//--save multiple contacts
		Contact ct1 = new Contact(102, "Soujanya", 8574968596L);
		Contact ct2 = new Contact(103, "Swathi", 9574968596L);
		Contact ct3 = new Contact(104, "Pankaj", 6574968596L);
		Contact ct4 = new Contact(105, "Bharath", 7574968596L);
		Contact ct5 = new Contact(106, "Valerie", 9874968596L);

		List<Contact> contacts = Arrays.asList(ct1, ct2, ct3, ct4, ct5);
		
		contactRepo.saveAll(contacts);		
		
		context.close();
	}
}
