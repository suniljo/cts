package com.cognizant.cms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cognizant.cms.entities.Contact;
import com.cognizant.cms.repositories.ContactRepository;
import com.cognizant.cms.services.ContactServices;

@Service
public class ContactServicesImpl implements ContactServices {
	private ContactRepository contactRepo;
	
	//-- constructor injection
  	@Autowired //optional - as there is only one constructor in this class 
	public ContactServicesImpl(ContactRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	@Override
	public List<Contact> getAllContactsInOrder() {
		//List<Contact> contacts = contactRepo.findAll();
		
		//-- approach -1 -- using findBy orderBy ----
		//List<Contact> contacts = contactRepo.findByOrderByContactName();
		//List<Contact> contacts = contactRepo.findByOrderByContactNameAsc();
		//List<Contact> contacts = contactRepo.findByOrderByContactNameDesc();
		//List<Contact> contacts = contactRepo.findByOrderByContactNameDescContactNumberAsc();
		//return contacts;
		
		//-- approach-2 -- using pre-defined findAll() method of JpaRepository -- sorting by Sort parameter
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName"));
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").ascending());
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").descending());
		//List<Contact> contacts = contactRepo.findAll(Sort.by("contactName", "contactNumber"));
		List<Contact> contacts = contactRepo.findAll(Sort.by("contactName").ascending().and(Sort.by("contactNumber").descending()));
		return contacts;
	}

}
