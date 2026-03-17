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
@RequestMapping(path = "/api")
public class DateRestController {

	@GetMapping(path = {"/date", "/today"})
	public ResponseEntity<String> showTodaysDateAndTime() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy  HH:mm:ss");
		
		String dt = dtFormatter.format(ldt);
		
		//ResponseEntity<String> respEntity = new ResponseEntity<String>(HttpStatus.OK);
		//ResponseEntity<String> respEntity = new ResponseEntity<String>(dt, HttpStatus.CREATED);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("company", "Cognizant");
		responseHeaders.add("location", "Hyderabad");
		ResponseEntity<String> respEntity = new ResponseEntity<String>(dt, responseHeaders, HttpStatus.CREATED);
		
		//return respEntity;
		
		//return ResponseEntity.ok().build();
		//return ResponseEntity.ok(dt);
		//return ResponseEntity.ok().body(dt);
		//return ResponseEntity.ok().headers(responseHeaders).body(dt);
		
		return ResponseEntity.badRequest().build();
	}
}
