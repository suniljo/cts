package com.cognizant.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.security.entities.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
	Optional<UserCredential> findByUsername(String username); 
}
