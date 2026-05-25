package com.cognizant.java.lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class BookServices {
	public List<Book> getAllBooksInAscendingOrderOfId() {
		BooksDAO booksDAO = new BooksDAO();
		List<Book> books = booksDAO.getAllBooks();

		// Comparator<Book> bookComp = (bk1, bk2) -> (bk1.getBookId() > bk2.getBookId())
		// ? 1 : -1;
		// books.sort(bookComp);

		books.sort((bk1, bk2) -> (bk1.getBookId() > bk2.getBookId()) ? 1 : -1);
		return books;
	}

	public List<Book> getAllBooksWithTitle(String title) {
		BooksDAO booksDAO = new BooksDAO();
		List<Book> books = booksDAO.getAllBooks();
		
		List<Book> filteredBooks = books.stream().filter(bk -> bk.getBookTitle().toLowerCase().indexOf(title.toLowerCase()) >=0 ).collect(Collectors.toList());
		
		return filteredBooks;
	}
}
