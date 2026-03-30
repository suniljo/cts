package com.cognizant.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeRestController.class);
	
	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		LOGGER.info("inside /welcome API");
		
		return "Welcome to Cognizant!!";
	}
}