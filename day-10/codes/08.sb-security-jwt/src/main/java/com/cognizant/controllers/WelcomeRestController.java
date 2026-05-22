package com.cognizant.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	private static Logger logger = LoggerFactory.getLogger(WelcomeRestController.class);

    @GetMapping("/welcome")
    public String showWelcomeMessage() {
        logger.info("/welcome starts..");
        return "Welcome to Cognizant..!!";
    }
}
