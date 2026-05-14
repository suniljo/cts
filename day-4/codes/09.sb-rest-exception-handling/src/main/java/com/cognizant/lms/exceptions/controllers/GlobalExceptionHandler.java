package com.cognizant.lms.exceptions.controllers;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.lms.exceptions.BookNotFoundException;
import com.cognizant.lms.models.ApiError;

import jakarta.servlet.http.HttpServletRequest;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException bex, HttpServletRequest httpRequest) {
		//return ResponseEntity.notFound().build();
		
		String type = bex.getClass().getName();
		String message = bex.getMessage();
		Integer sc = 404;
		LocalDate when = LocalDate.now();
		String api = httpRequest.getRequestURI();
		String method = httpRequest.getMethod();
		
		ApiError error = new ApiError();
		
		error.setType(type);
		error.setMessage(message);
		error.setStatusCode(sc);
		error.setWhen(when);
		error.setMethod(method);
		error.setApi(api);
		
		return ResponseEntity.ok().body(error);
	}
}
