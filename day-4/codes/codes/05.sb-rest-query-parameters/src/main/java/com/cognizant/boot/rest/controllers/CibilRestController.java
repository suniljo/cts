package com.cognizant.boot.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cibil")
public class CibilRestController {
	
	@GetMapping(path = "/score")
	public ResponseEntity<?> findCibilScore(@RequestParam("name") String customerName, 
											@RequestParam(value = "pan", required = false) String pan){
		if(pan != null && pan.length() == 10) {
			//get the cibil score from data store
			int score = 798;
			String msg = String.format("Hi %s, your PAN is %s, & your CIBIL Score is %d", customerName, pan, score);
			return ResponseEntity.ok().body(msg);
		}else {
			return ResponseEntity.badRequest().body("Please provide a Valid PAN");
		}
	}
}
