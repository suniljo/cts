package com.cognizant.cms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println();
		
		ContactRepository contactRepo = context.getBean(ContactRepository.class);
		
		/*
		//--get first 5 contacts
		Pageable pageable = Pageable.ofSize(5);
		Page<Contact> contactPage = contactRepo.findAll(pageable);
		List<Contact> contacts = contactPage.getContent();
		printContacts(contacts);
		*/
		
		/*
		//int pageNo = 0; //first page
		int pageNo = 1; //second page
		int pageSize = 4; 
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Contact> contactPage = contactRepo.findAll(pageRequest);
		List<Contact> contacts = contactPage.getContent();
		printContacts(contacts);
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
			printContacts(contacts, pageNo, noOfPages);			
		}
		context.close();
	}

	private static void printContacts(List<Contact> contacts, int pageNo, long noOfPages) {
		System.out.println(String.format("\n-------------- Page %2d / %2d of Contacts --------------", (pageNo+1), noOfPages));
		contacts.forEach(System.out::println);
	}

	private static void printContacts(List<Contact> contacts) {
		contacts.stream()
				.forEach(ct -> {
					System.out.println(ct);
					try {
						TimeUnit.SECONDS.sleep(1);
					}catch(Exception ex) {}
				});
		
	}

}
