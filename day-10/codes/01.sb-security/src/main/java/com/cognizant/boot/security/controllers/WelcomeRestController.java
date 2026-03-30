package com.cognizant.boot.security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	@GetMapping(path = "/welcome")
	public ResponseEntity<String> showWelcomeMessage() {
		Object principal = SecurityContextHolder.getContext()
												.getAuthentication()
												.getPrincipal();

		String userName = "";
		if (principal instanceof UserDetails) {
			UserDetails usrDtls = (UserDetails) principal;

			userName = usrDtls.getUsername();
			String pass = usrDtls.getPassword();

			System.out.println("user name: " + userName);
			System.out.println("password: " + pass);

		}
		return ResponseEntity.ok("Welcome to Congnizant");
	}
}
