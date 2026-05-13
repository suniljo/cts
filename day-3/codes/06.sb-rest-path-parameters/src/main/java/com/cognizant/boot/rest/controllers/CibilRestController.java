package com.cognizant.boot.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CibilRestController {
	
	//@GetMapping(path= {"/api/v1/cibil/score/{name}/{pan}", "/api/v1/cibil/score/{name}"})
	@GetMapping(path= "/api/v1/{name}/cibil/{pan}/score")
	public ResponseEntity<?> getCibilScore(@PathVariable("name") String customerName,
										   @PathVariable(required=false) String pan){
		
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
