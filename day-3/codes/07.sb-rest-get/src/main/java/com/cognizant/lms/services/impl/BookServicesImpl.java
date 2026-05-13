package com.cognizant.lms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.lms.models.Book;
import com.cognizant.lms.repository.BookRepository;
import com.cognizant.lms.services.BookServices;

@Service
public class BookServicesImpl implements BookServices {
	private BookRepository bookRepo;
	private List<Book> books;
	
	//constructor injection
	@Autowired
	public BookServicesImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
		this.books = bookRepo.getAllBooks();
	}
	
	@Override
	public List<Book> getBooks() {		
		return books;
	}



	@Override
	public Book getBookById(Integer bid) {
		Book searchedBook = books.stream()
								 .filter(bk -> bk.getBookId().equals(bid))
								 .findFirst()
								 .orElse(null);
		return searchedBook;
	}

}
