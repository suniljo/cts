package com.cognizant.lms.exceptions.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
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
  public ResponseEntity<ApiError> handleBookNotFoundException(BookNotFoundException bex, HttpServletRequest httpRequest){
	  //return new ResponseEntity<String>(bex.getMessage(), HttpStatus.NOT_FOUND);
	  ApiError error = new ApiError();
	  
	  String type = bex.getClass().getName();
	  Integer status = 404;
	  String message = bex.getMessage();
	  LocalDateTime time = LocalDateTime.now();
	  String uri = httpRequest.getRequestURI();
	  
	  error.setType(type);
	  error.setStatus(status);
	  error.setMessage(message);
	  error.setTime(time);
	  error.setUri(uri);
	  error.setMethod(httpRequest.getMethod());
	  
	  return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
  }
}
