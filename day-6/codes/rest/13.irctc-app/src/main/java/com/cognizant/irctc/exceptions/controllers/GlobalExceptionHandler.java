package com.cognizant.irctc.exceptions.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.irctc.exceptions.TicketNotFoundException;
import com.cognizant.irctc.models.ApiError;

import jakarta.servlet.http.HttpServletRequest;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<?> handleTicketBotFoundException(TicketNotFoundException tex, HttpServletRequest request){
		//return ResponseEntity.badRequest().body(tex.getMessage());

		ApiError apiError = new ApiError();
		
		apiError.setMessage(tex.getMessage());
		
		String exType = tex.getClass().getName();
		apiError.setType(exType);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.now();
		String exDate = formatter.format(ldt);
		apiError.setDate(exDate);
		
		String path = request.getRequestURI();
		apiError.setPath(path);
		
		String httpMethod = request.getMethod();
		apiError.setMethod(httpMethod);
		
		//return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
		return ResponseEntity.badRequest().body(apiError);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationFailures(MethodArgumentNotValidException ex) {
		/*
		 * BindingResult bindingResult = ex.getBindingResult(); 
		 * List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		 * System.out.println(fieldErrors.size());
		 * 
		 * for (FieldError fieldErr : fieldErrors) {
		 * 		System.out.println(fieldErr.getField() + " - " + fieldErr.getDefaultMessage()); 
		 * }
		 */

		List<String> errors = ex.getBindingResult()
								.getFieldErrors()
								.stream()
								.map(except -> except.getField() + ": " + except.getDefaultMessage())
								.collect(Collectors.toList());
		
		return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
		
	}	
}
