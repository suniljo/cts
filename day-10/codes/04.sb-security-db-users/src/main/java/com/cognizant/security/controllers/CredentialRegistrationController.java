package com.cognizant.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.security.entities.UserCredential;
import com.cognizant.security.repositories.UserCredentialRepository;

@RestController
public class CredentialRegistrationController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserCredentialRepository userRepo;
	
	@PostMapping("/register/user")
	public UserCredential createUser(@RequestBody UserCredential user) {
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		
		user.setPassword(encodedPassword);
		
		UserCredential savedUserCredential = userRepo.save(user);
		return savedUserCredential;
	}
}
