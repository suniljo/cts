package com.cognizant.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to State Bank of India";
	}

	@GetMapping("/admin")
	public String adminPage() {
		return "This API is for Administrators";
	}

	@GetMapping("/manager")
	public String managerPage() {
		return "This API is for Administrators & Managers";
	}

	@GetMapping("/clerk")
	public String clerkPage() {
		return "This API is for Administrators, Managers & Clerks";
	}

	@GetMapping("/customer")
	public String customerPage() {
		return "This page is for any Autheticated User";
	}

	@GetMapping("/care")
	public String customerCarePage() {
		return "Contact State Bank of India";
	}
}
