package com.cognizant.lms.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.lms.models.Book;
import com.cognizant.lms.services.LibraryServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/library")
@Tag(name = "Librar Controller", description = "APIs to add new book, search for a book, all books, delete and update")
public class LibraryRestController {

	private LibraryServices libService;
	
	//constructor injection
	public LibraryRestController(LibraryServices libService) {
		super();
		this.libService = libService;
	}
	
	@GetMapping
	public List<Book> getAllBooks(){
		return libService.findAll();
	}
	
	@GetMapping(path = "/{bid}", produces = {"application/json", "application/xml"})
	@Operation(summary = "Search a Book",
    			description = "search book based on ISBN")
	public ResponseEntity<?> searchBookById(@PathVariable Integer bid) {
		Book searchedBook = libService.findBookById(bid);
		//if(searchedBook != null)
		return ResponseEntity.ok().body(searchedBook);
		
		//return ResponseEntity.badRequest().body("No matching book with ID: " + bid);
	}
	
	
	@PostMapping(consumes = {"application/json", "application/xml"},
				 produces = {"application/json", "application/xml"})
	public ResponseEntity<?> addNewBook(@Valid @RequestBody Book newBook){
		Book savedBook = libService.saveBook(newBook);
		if(savedBook == null)
			return ResponseEntity.badRequest().body("Book already exists with Book ID:" + newBook.getBookId());
		
		return new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{bid}")
	public ResponseEntity<Book> modifyExistingBook(@PathVariable Integer bid, @RequestBody Book book){
		Book updatedBook = libService.modifyBook(bid, book);
		if(updatedBook != null) {
			return ResponseEntity.ok(updatedBook);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path="/{bid}")
	public ResponseEntity<?> deleteExistingBook(@PathVariable Integer bid){
		libService.deleteBookById(bid);
		return ResponseEntity.ok().build();
	}	
}
