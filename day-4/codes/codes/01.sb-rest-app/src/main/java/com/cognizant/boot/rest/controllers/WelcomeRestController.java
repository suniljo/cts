package com.cognizant.boot.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
@Controller
@ResponseBody
*/
@RestController
public class WelcomeRestController {
	
	//@RequestMapping("/welcome")
	//@RequestMapping(value = "/welcome")
	//@RequestMapping(path = "/welcome")
	//@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	//@GetMapping("/welcome")
	//@GetMapping(value = "/welcome")
	@GetMapping(path = "/welcome")
	public String showWelcomeMessage() {
		return "Welcome to Cognizant!!";
	}
}
