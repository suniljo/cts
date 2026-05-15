package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		//-- get repository bean
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		/*
		 * ContactRepository is an interface - then how come instance/bean? 
		 * - uses Proxy Design Pattern- implementation class is being created internally
		*/
		
		System.out.println("repository implementation class name = " + contactRepo.getClass().getName());
		System.out.println();
		
		/*
		//--save a contact
		Contact ct1 = new Contact();
		ct1.setContactId(101);
		ct1.setContactName("Sanjay Patil");
		ct1.setContactNumber(1234567890L);
		*/
		
		/*
		//-- save a contact
		//contactRepo.save(ct1);
		Contact savedContact = contactRepo.save(ct1);
		System.out.println(savedContact);
		*/
		
		//-- save multiple contacts
		Contact ct1 = new Contact(102, "Veena", 8574968596L);
		Contact ct2 = new Contact(103, "Sooraj", 9574968596L);
		Contact ct3 = new Contact(104, "Sachin", 6574968596L);
		Contact ct4 = new Contact(105, "Kiran", 7574968596L);
		Contact ct5 = new Contact(106, "Chris", 1111111111L);
		
		List<Contact> contacts = Arrays.asList(ct1, ct2, ct3, ct4, ct5);
		contactRepo.saveAll(contacts);
	}

}
