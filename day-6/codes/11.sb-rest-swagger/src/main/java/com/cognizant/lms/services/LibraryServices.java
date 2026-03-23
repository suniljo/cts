package com.cognizant.lms.services;

import java.util.List;

import com.cognizant.lms.models.Book;

public interface LibraryServices {
	public Book findBookById(Integer bid);
	public List<Book> findAll();
	public Book saveBook(Book newBook);
	public Book modifyBook(Integer bid, Book book);
	public void deleteBookById(Integer bid);
}
