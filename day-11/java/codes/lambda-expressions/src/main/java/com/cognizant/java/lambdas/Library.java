package com.cognizant.java.lambdas;

import java.util.List;
import java.util.function.Consumer;

public class Library {

	public static void main(String[] args) throws InterruptedException {
		BookServices libraryService = new BookServices();
		
		List<Book> books = libraryService.getAllBooksInAscendingOrderOfId();
		
		/*
		for(Book bk : books) {
			System.out.println(bk);
		}
		*/
		
		//books.forEach(bk -> System.out.println(bk));
		books.forEach(System.out::println);	 //method reference
		System.out.println();
		
		List<Book> bookTitles = libraryService.getAllBooksWithTitle("Jav");
		bookTitles.forEach(System.out::println);
	}
}