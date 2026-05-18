package com.cognizant.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.cms.entities.Contact;

@Repository //optional
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
