package com.cognizant.boot.rest.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class WelcomeRestController {
	
	@PostMapping(path = "/welcome")
	public String showWelcomeMessagePost() {
		return "Welcome to Cognizant from POST";
	}
	
	@GetMapping(path = "/welcome")
	public String showWelcomeMessageGet() {
		return "Welcome to Cognizant from GET";
	}
	
	@PutMapping(path = "/welcome")
	public String showWelcomeMessagePut() {
		return "Welcome to Cognizant from PUT";
	}
	
	@PatchMapping(path = "/welcome")
	public String showWelcomeMessagePatch() {
		return "Welcome to Cognizant from PATCH";
	}
	
	@DeleteMapping(path = "/welcome")
	public String showWelcomeMessageDelete() {
		return "Welcome to Cognizant from DELETE";
	}	
	
}
