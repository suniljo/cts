package com.cognizant.cms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.entities.Contact;

@Repository //optional
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
