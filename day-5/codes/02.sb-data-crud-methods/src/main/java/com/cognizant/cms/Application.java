package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepo;
	
	public static void main(String[] args) {
		//System.out.println("IoC about to initialize");
		log.info("IoC about to initialize");
		SpringApplication.run(Application.class, args);
		//System.out.println("IoC initialized!!");
		log.info("IoC initialized");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("inside run method");
		
		//-- get the number of contacts
		long noOfContacts = contactRepo.count();
		System.out.println("no of contacts = " + noOfContacts);
		log.warn("no of contacts = {}", noOfContacts);
		
		System.out.println();
		
		//-- check whether a contact is existing with a specific id
		boolean isContactExists = contactRepo.existsById(101);
		System.out.println("contact with contactid: 101 exists = " + isContactExists);
		System.out.println();
		
		//-- get a Contact based on contactId( ID property value)
		Optional<Contact> optContact = contactRepo.findById(1014);
		if(optContact.isPresent()) {
			Contact contact = optContact.get();
			System.out.println(contact);
		}else {
			System.err.println("no matching contact found!!");
		}
		System.out.println();
		
		//--- get Contacts based on multiple contactIds
		List<Integer> contactIds = Arrays.asList(101, 202, 405, 104, 102);
		Iterable<Contact> contacts = contactRepo.findAllById(contactIds);
		printContacts(contacts);
		System.out.println();
		
		//--- get all contacts
		contacts = contactRepo.findAll();
		printContacts(contacts);
		System.out.println();
		
		//--delete a contact by id
		contactRepo.deleteById(107);
		
	}

	private void printContacts(Iterable<Contact> contacts) {
		contacts.forEach(ct -> {
			System.out.println(ct);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});		
	}

}
