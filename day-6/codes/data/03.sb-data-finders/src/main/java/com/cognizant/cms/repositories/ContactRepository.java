package com.cognizant.cms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.cms.entities.Contact;

@Repository //optional
public interface ContactRepository extends CrudRepository<Contact, Integer> {

	Optional<Contact> findByContactName(String contactName);

	Contact findByContactNumber(long contactNumber);

	Optional<Contact> findByContactNameAndContactNumber(String cname, String cno);

	List<Contact> findByContactNameOrContactNumber(String name, String number);

	//@Query("select contactName from com.cognizant.cms.entities.Contact") //HQL - Hibernate Query Language
	//@Query(value = "select contactName from com.cognizant.cms.entities.Contact") //HQL - Hibernate Query Language
	@Query(value = "select contact_name from contact_master", nativeQuery = true) //SQL - Structured Query Language
	List<String> findContactNames();

	//@Query("from com.cognizant.cms.entities.Contact where contactName=?1") //positional parameters
	//@Query("select ct from com.cognizant.cms.entities.Contact ct where contactName=?1") //positional parameters
	//@Query("from com.cognizant.cms.entities.Contact where contactName=:cname") //named-parameters
	//@Query("select ct from com.cognizant.cms.entities.Contact ct where contactName=:cname") //named parameters
	@Query(value = "select * from CONTACT_MASTER where CONTACT_NAME=:cname", nativeQuery = true) //SQL
	Optional<Contact> findByName(String cname);

	@Query(value = "select ct from com.cognizant.cms.entities.Contact ct where contactName LIKE :nameStarts%")
	List<Contact> findContactsWithNameStartsWith(String nameStarts);

	@Transactional
	@Modifying
	@Query("update com.cognizant.cms.entities.Contact set contactNumber=:cno where contactId=:cid")
	void modifyContactNumber(int cid, long cno);
	
}
