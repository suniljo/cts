package com.cognizant.lms.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.lms.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
