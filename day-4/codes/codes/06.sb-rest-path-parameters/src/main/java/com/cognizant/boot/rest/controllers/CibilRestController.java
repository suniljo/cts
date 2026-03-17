package com.cognizant.boot.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cibil")
public class CibilRestController {
	@GetMapping(path = {"/score/{cname}/{pan}", "/score/{cname}"})
	public ResponseEntity<?> findCibilScore(@PathVariable String cname, @PathVariable(value = "pan", required=false) String pan){
		if(pan != null && pan.length()==10)
			return ResponseEntity.ok().body(String.format("PAN: %s || Score: 785", pan));
		else
			return ResponseEntity.badRequest().body("Please provide correct PAN");
	}
}
