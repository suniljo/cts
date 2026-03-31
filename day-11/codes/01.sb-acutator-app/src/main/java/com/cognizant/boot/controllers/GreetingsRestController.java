package com.cognizant.boot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class GreetingsRestController {
	@GetMapping(path = {"/greet", "/greetings"})
	public String showWelcomeMessage() {
		return "Greetings from Congizant";
	}
}
