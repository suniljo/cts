package com.cognizant.lms.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.lms.exceptions.BookNotFoundException;
import com.cognizant.lms.models.Book;
import com.cognizant.lms.repositories.LibraryRepository;
import com.cognizant.lms.services.LibraryServices;

@Service
public class LibrayServicesImpl implements LibraryServices {
	private LibraryRepository libRepo;
	private List<Book> books;
	
	//constructor injection
	public LibrayServicesImpl(LibraryRepository libRepo) {
		super();
		this.libRepo = libRepo;
		this.books = libRepo.getBooks();
	}

	@Override
	public Book findBookById(Integer bid) {
		Book book = books.stream()
						 .filter(bk -> bk.getBookId().equals(bid))
						 .findFirst()
						 .orElse(null);
		if(book != null)
			return book;
		
		throw new BookNotFoundException("Book with BookID: " + bid+" not in Library");
	}

	@Override
	public List<Book> findAll() {
		return books;
	}

	@Override
	public Book saveBook(Book newBook) {
		boolean isBookExists = books.stream()
									.anyMatch(book -> book.getBookId().equals(newBook.getBookId()));
		
		if(!isBookExists) {
			books.add(newBook);
			return newBook;
		}
		return null;
	}

	@Override
	public Book modifyBook(Integer bid, Book book) {
		for(int i=0; i<books.size(); i++) {
			Book bk = books.get(i);
			if(bid.equals(bk.getBookId())) {
				bk.setBookTitle(book.getBookTitle());
				bk.setBookPrice(book.getBookPrice());
				books.set(i, bk);
				return bk;
			}
		}//for
		return null;
	}

	@Override
	public void deleteBookById(Integer bid) {
		for(int i=0; i<books.size(); i++) {
			Book bk = books.get(i);
			if(bk.getBookId().equals(bid)) {
				books.remove(i);
			}
		}
		
		throw new BookNotFoundException("Book with BookID: " + bid+" not in Library");
	}
}
