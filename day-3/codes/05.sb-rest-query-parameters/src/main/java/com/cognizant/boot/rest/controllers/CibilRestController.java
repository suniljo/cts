package com.cognizant.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cibil")
public class CibilRestController {
	
	@GetMapping
	public ResponseEntity<?> getCibilScore(@RequestParam("name") String customerName,
										   @RequestParam(value="pan", required=false) String pan){
		
		//logic to get the CIBIL Score from data store
		int score = 798;
		
		if(pan != null && pan.length()==10) {
			return ResponseEntity.ok().body(String.format("Hi %s, your PAN is %s & Score is %d", customerName, pan, score));
		}else {
			//return ResponseEntity.badRequest().build();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
