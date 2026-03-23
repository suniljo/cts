package com.cognizant.lms.exceptions.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
  
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException mex){
	  List<FieldError> errorList = mex.getBindingResult().getFieldErrors();
	  
	  /*
	  System.out.println("no of validation failures = " + errorList.size());
	  for(FieldError fieldErr : errorList) {
		  System.out.println(fieldErr.getField()+" = " + fieldErr.getDefaultMessage());
	  }
	  */
	  
	  /*
	  Map<String, String> errorsMap = new HashMap<String, String>();
	  for(FieldError fieldErr : errorList) {
		  String fieldName = fieldErr.getField();
		  String fieldErrMsg = fieldErr.getDefaultMessage();
		  
		  errorsMap.put(fieldName, fieldErrMsg);
	  }
	  */
	  /*
	  Map<String, String> errorsMap = errorList.stream()
			  								   .collect(Collectors.toMap(FieldError::getField, 
			  										   					 FieldError::getDefaultMessage));
	  */
	  Map<String, String> errorsMap = errorList.stream()
				   .collect(Collectors.toMap(FieldError::getField, 
						   					 FieldError::getDefaultMessage, 
						   					 (oldMessage, newMessage) -> oldMessage));	 
	  
	  return ResponseEntity.badRequest().body(errorsMap);
  }
}
