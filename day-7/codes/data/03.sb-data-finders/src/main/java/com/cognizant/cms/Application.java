package com.cognizant.cms;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public Application(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contact contact = null;
		
		Optional<Contact> optContact = contactRepo.findByContactName("Sanjay Patil");
		if(optContact.isPresent()) {
			contact = optContact.get();
			System.out.println(contact);
		}else {
			System.err.println("No matching contact found!!");
		}
		System.out.println();
		
		Long cno = 9848586878L;
		contact = contactRepo.findByContactNumber(cno);
		if(contact != null)
			System.out.println(contact);
		else
			LOGGER.warn("no matching contact for contact Number: {}", cno);
		System.out.println();	
		
		optContact = contactRepo.findByContactNameAndContactNumber("Bharath", "9574968596");
		if(optContact.isPresent()) {
			contact = optContact.get();
			LOGGER.info(contact.toString());
		}else {
			LOGGER.error("no matching contacts found");
		}
		System.out.println();
		
		List<Contact> contacts = contactRepo.findByContactNameOrContactNumber("Sanjay Patil", "9574968596");
		contacts.forEach(System.out::println);
		System.out.println();		
		
		List<String> contactNames = contactRepo.findContactNames();
		contactNames.forEach(cname -> System.out.println(cname));
		System.out.println();
		
		String cname = "Soujanya";
		optContact = contactRepo.findByName(cname);
		if(optContact.isPresent()) {
			contact = optContact.get();
			System.out.println(contact);
		}else {
			LOGGER.error("no matching contact for contact Name: {}", cname);
		}
		System.out.println();	
		
		contacts = contactRepo.findContactsWithNameStartsWith("S");
		contacts.forEach(System.out::println);
		System.out.println();	
		
		contactRepo.modifyContactNumber(102, 2111111111L);
	}

}
