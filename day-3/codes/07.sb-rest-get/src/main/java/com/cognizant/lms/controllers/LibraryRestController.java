package com.cognizant.lms.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.lms.models.Book;
import com.cognizant.lms.services.BookServices;

@RestController
@RequestMapping(path = "/api/library")
public class LibraryRestController {
	private BookServices bookServices;
	
	public LibraryRestController(BookServices bookServices) {
		super();
		this.bookServices = bookServices;
	}

	@GetMapping
	public List<Book> showAllBooks(){
		List<Book> books = bookServices.getBooks();
		return books;
	}
	
	@GetMapping(path = "/{bookId}", produces = {"application/json", "application/xml"})
	public ResponseEntity<?> searchBookById(@PathVariable Integer bookId){
		Book searchedBook = bookServices.getBookById(bookId);
		
		if(searchedBook != null) {
			return ResponseEntity.ok(searchedBook);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
