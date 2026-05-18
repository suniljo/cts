package com.cognizant.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private ContactRepository contactRepo;
	
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
		/*
		//-- to fetch first 5 contacts
		Pageable pageableRef = Pageable.ofSize(5);
		Page<Contact> contactPage = contactRepo.findAll(pageableRef);
		List<Contact> contacts = contactPage.getContent();
		contacts.forEach(System.out::println);
		System.out.println();
		*/
		
		/*
		//int pageNo = 0; //first page
		int pageNo = 1; //second page
		int pageSize = 4;
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Contact> contactPage = contactRepo.findAll(pageRequest);
		List<Contact> contacts = contactPage.getContent();
		contacts.forEach(System.out::println);
		System.out.println();
		*/
		
		int pageSize = 4;
		long noOfPages = contactRepo.count() / pageSize;
		if(contactRepo.count() % pageSize > 0) {
			noOfPages++;
		}
		
		for(int pageNo=0; pageNo<noOfPages; pageNo++) {
			PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
			Page<Contact> contactPage = contactRepo.findAll(pageRequest);
			List<Contact> contacts = contactPage.getContent();
			printContactsPagewise(pageNo, noOfPages, contacts);
		}
	}

	private void printContactsPagewise(int pageNo, long noOfPages, List<Contact> contacts) {
		System.out.println();
		System.out.println(String.format("===============  Contacts List  Page %d / %d   ===============", (pageNo+1), noOfPages));
		
		contacts.forEach(ct -> System.out.println(ct));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
