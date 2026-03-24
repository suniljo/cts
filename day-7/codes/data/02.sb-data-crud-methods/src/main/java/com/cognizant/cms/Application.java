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
		System.out.println("main method starts");
		SpringApplication.run(Application.class, args);
		System.out.println("main method ends");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("inside run method");
		//System.out.println(contactRepo);
		System.out.println();
		
		//-- get the number of contacts --
		long noOfContacts = contactRepo.count();
		log.info("no of contacts: {}", noOfContacts);
		System.out.println();
		
		//-- check whether a contact is existing with a specific id
		boolean isExists = contactRepo.existsById(101);
		log.info("contact with id: 101 exists: {}", isExists);
		System.out.println();
		
		//-- get a Contact based on contactId( ID property value)
		Contact contact = null;
		int contactId = 101;
		Optional<Contact> optContact = contactRepo.findById(contactId);
		if(optContact.isPresent()) {
			contact = optContact.get();
			System.out.println(contact);
		}else {
			log.error("no contact with contact id: {}", contactId);
		}
		System.out.println();
		
		//--- get Contacts based on multiple contactIds
		List<Integer> contactIds = Arrays.asList(101,202,208,107,103,109);		
		Iterable<Contact> contacts = contactRepo.findAllById(contactIds);
		printContacts(contacts);
		System.out.println();
		
		//--- get all contacts
		contacts = contactRepo.findAll();
		printContacts(contacts);
		System.out.println();
		
		//--delete a contact by id
		contactRepo.deleteById(107);
		
		System.out.println();
	}

	private void printContacts(Iterable<Contact> contacts) {
		contacts.forEach(System.out::println);		
	}

}
