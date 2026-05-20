package com.cognizant.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.library.entity.Book;

public interface LibraryRepository extends JpaRepository<Book, Integer> {

}
