package com.cognizant.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.entities.Contact;

@Repository //optional
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByOrderByContactName();
	List<Contact> findByOrderByContactNameAsc();
	List<Contact> findByOrderByContactNameDesc();
	List<Contact> findByOrderByContactNameDescContactNumberAsc();
}
