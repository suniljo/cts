package com.cognizant.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.services.WelcomeServices;

@RestController
@RequestMapping(path = "/api/v1")
public class WelcomeRestController {
	
	@Autowired
	private WelcomeServices welServices;
	
	@GetMapping(path = "/welcome")
	public ResponseEntity<String> showWelcomeMessage() {
		String welcomeMessage = welServices.generateWelcomeMessage();
		return ResponseEntity.ok().body(welcomeMessage);
	}
}
