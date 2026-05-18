package com.cognizant.cms;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
			
	private ContactRepository contactRepo;
	
	//constructor injection
	@Autowired
	public Application(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Optional<Contact> optContact = contactRepo.findByContactName("Sooraja");
		if(optContact.isPresent()) {
			Contact contact = optContact.get();
			LOGGER.info(contact.toString());
		}else {
			LOGGER.error("no matching contact found!");
		}
		System.out.println();
		
		Contact contact = contactRepo.findByContactNumber(7574968596L);
		if(contact != null) {
			LOGGER.info(contact.toString());
		}else {
			LOGGER.error("no matching contact found!");
		}
		System.out.println();
		
		optContact = contactRepo.findByContactNameAndContactNumber("Bharath", "9574968596");
		if(optContact.isPresent()) {
			contact = optContact.get();
			LOGGER.info(contact.toString());
		}else {
			LOGGER.error("no matching contacts found");
		}
		System.out.println();
		
		List<Contact> contacts = contactRepo.findByContactNameOrContactNumber("Sanjay Patil", "1111111111");
		contacts.forEach(System.out::println);
		System.out.println();
		
		List<String> contactNames = contactRepo.findContactNames();
		contactNames.forEach(cname -> System.out.println(cname));
		System.out.println();
		
		String cname = "Veena";
		optContact = contactRepo.findByName(cname);
		if(optContact.isPresent()) {
			contact = optContact.get();
			System.out.println(contact);
		}else {
			LOGGER.error("no matching contact for contact Name: {}", cname);
		}
		System.out.println();	
		
		List<Contact> contacts1 = contactRepo.findContactsWithNameStartsWith("S");
		contacts1.forEach(System.out::println);
		System.out.println();
		
		contactRepo.modifyContactNumber(102, 2111111111L);
	}

}
