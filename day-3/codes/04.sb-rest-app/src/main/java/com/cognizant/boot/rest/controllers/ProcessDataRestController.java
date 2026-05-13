package com.cognizant.boot.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class ProcessDataRestController {
	
	@PostMapping(path = "/process-data")
	public ResponseEntity<String> processRequestHeaderAndBody(@RequestHeader("Host") String host,
															@RequestHeader(name="company", required=false, defaultValue="NA") String company,
															@RequestBody(required=false) String requestData){
		
		String responseText = String.format("Host Name: %s\nCompany: %s\nRequest Data: %s", host, company, requestData);
		
		return ResponseEntity.ok().body(responseText);
	}
}
