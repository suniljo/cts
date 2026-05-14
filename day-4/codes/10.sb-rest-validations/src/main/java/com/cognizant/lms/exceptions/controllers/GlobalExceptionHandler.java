package com.cognizant.lms.exceptions.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException bex, HttpServletRequest httpRequest) {
		// return ResponseEntity.notFound().build();

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

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationFailures(MethodArgumentNotValidException mex) {
		BindingResult bindingResult = mex.getBindingResult();
		List<FieldError> fieldErrorsList = bindingResult.getFieldErrors();

		/*
		 System.out.println("no of validation failures = " + fieldErrorsList.size());
		 for (FieldError fieldErr : fieldErrorsList) {
		     System.out.println(fieldErr.getField() + " = " +
		     fieldErr.getDefaultMessage()); 
		 }
		*/
		
		/*
		Map<String, String> errorsMap = new HashMap<String, String>();
		for (FieldError fieldErr : fieldErrorsList) {
			String fieldName = fieldErr.getField();
			String fieldErrMsg = fieldErr.getDefaultMessage();

			errorsMap.put(fieldName, fieldErrMsg);
		}
		*/
		
		/*
		  Map<String, String> errorsMap = fieldErrorsList.stream()
					   						.collect(Collectors.toMap(FieldError::getField, 
					   												  FieldError::getDefaultMessage));
		*/
		
		  Map<String, String> errorsMap = fieldErrorsList.stream()
				   .collect(Collectors.toMap(FieldError::getField, 
						   					 FieldError::getDefaultMessage, 
						   					 (oldMessage, newMessage) -> oldMessage));	
		  
		return ResponseEntity.badRequest().body(errorsMap);
	}
}
