package com.cognizant.lms.services.impl;

import org.springframework.stereotype.Service;

import com.cognizant.lms.dtos.BookDTO;
import com.cognizant.lms.entities.Book;
import com.cognizant.lms.mappers.BookMapper;
import com.cognizant.lms.repositories.BookRepository;
import com.cognizant.lms.services.BookServices;

@Service
public class BookServicesImpl implements BookServices {
	private BookRepository bookRepo;	
	
	public BookServicesImpl(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}


	@Override
	public BookDTO saveBook(BookDTO bookDTO) {
		Book bookEntity = BookMapper.dtoToEntity(bookDTO);
		Book savedBookEntity = bookRepo.save(bookEntity);
		BookDTO bookDtoToReturn = BookMapper.entityToDTO(savedBookEntity);
		return bookDtoToReturn;
	}

}
