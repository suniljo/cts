package com.cognizant.boot.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ProcessHeaderAndBodyRestController {
	
	@PostMapping(path = "/process-data")
	public ResponseEntity<?> processHeaderAndRequestData(@RequestHeader("Host") String host,
														 @RequestHeader(value = "company", required=false, defaultValue = "NA") String companyName,
														 @RequestBody(required=false) String empData){
		if(empData == null) {
			return ResponseEntity.badRequest().build();
		}
		String processedData = String.format("Host: %s\nCompany: %s\nRequest Data: %s", host, companyName, empData);
		return ResponseEntity.ok().body(processedData);		
	}
}
