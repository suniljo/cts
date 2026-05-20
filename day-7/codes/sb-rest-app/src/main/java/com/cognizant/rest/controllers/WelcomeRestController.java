package com.cognizant.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class WelcomeRestController {

	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		return "Welcome to Cognizant";
	}
}
