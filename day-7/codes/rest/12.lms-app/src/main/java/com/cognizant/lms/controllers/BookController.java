package com.cognizant.lms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.lms.dtos.BookDTO;
import com.cognizant.lms.services.BookServices;

@RestController
@RequestMapping(path = "api/library")
public class BookController {
	private BookServices bookServices;

	public BookController(BookServices bookServices) {
		super();
		this.bookServices = bookServices;
	}

	@PostMapping
	public BookDTO addNewBook(@RequestBody BookDTO dto) {
		return bookServices.saveBook(dto);
	}
	
	@GetMapping(path = "/{bid}")
	public ResponseEntity<BookDTO> getBookByBookId(@PathVariable Long bid){
		BookDTO book = bookServices.searchBookById(bid);
		if(book != null)
			return ResponseEntity.ok().body(book);
		return ResponseEntity.notFound().build();
	}
}
