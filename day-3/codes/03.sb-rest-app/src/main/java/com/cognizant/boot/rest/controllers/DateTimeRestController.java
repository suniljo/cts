package com.cognizant.boot.rest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DateTimeRestController {
	
	@GetMapping(path = {"/date", "/today"})
	public ResponseEntity<String> getTodaysDateAndTime(){
		LocalDateTime localDt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:YYYY HH:mm:ss");
		
		String dateTime = formatter.format(localDt);
		
		/*
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, HttpStatus.OK);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("company", "Cognizant");
		responseHeaders.add("location", "Hyderabad");
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(dateTime, responseHeaders, HttpStatus.CREATED);
		return responseEntity;
		*/
		
		//return ResponseEntity.badRequest().build();
		
		//return ResponseEntity.ok().build();
		//return ResponseEntity.ok(dateTime);
		//return ResponseEntity.ok().body(dateTime);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("company", "Cognizant");
		responseHeaders.add("location", "Hyderabad");
		
		return ResponseEntity.ok().headers(responseHeaders).body(dateTime);		
	}
}
