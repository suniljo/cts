package com.cognizant.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeRestController.class);

	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		LOGGER.info("inside /welcome API");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String userName = "";

		if (principal instanceof UserDetails) {
			UserDetails usrDtls = (UserDetails) principal;

			userName = usrDtls.getUsername();
			String pass = usrDtls.getPassword();

			System.out.println("user name: " + userName);
			System.out.println("password: " + pass);

		}
		return "Welcome to Cognizant!!";
	}
}