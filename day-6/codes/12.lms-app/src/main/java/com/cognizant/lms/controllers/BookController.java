package com.cognizant.lms.controllers;

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
}
