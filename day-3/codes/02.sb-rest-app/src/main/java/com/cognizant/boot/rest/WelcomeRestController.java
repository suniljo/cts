package com.cognizant.boot.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WelcomeRestController {
	@GetMapping(path = "/welcome")
	public String showWelcomeMessageGet() {
		return "Welcome to Congnizant - GET";
	}
	
	@PostMapping(path = "/welcome")
	public String showWelcomeMessagePost() {
		return "Welcome to Congnizant - POST";
	}
	
	@PutMapping(path = "/welcome")
	public String showWelcomeMessagePut() {
		return "Welcome to Congnizant - PUT";
	}
	
	@DeleteMapping(path = "/welcome")
	public String showWelcomeMessageDelete() {
		return "Welcome to Congnizant - DELETE";
	}
	
	@PatchMapping(path = "/welcome")
	public String showWelcomeMessagePatch() {
		return "Welcome to Congnizant - PATCH";
	}
}
