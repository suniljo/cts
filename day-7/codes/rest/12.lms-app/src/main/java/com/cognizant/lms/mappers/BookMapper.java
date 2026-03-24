package com.cognizant.lms.mappers;

import com.cognizant.lms.dtos.BookDTO;
import com.cognizant.lms.entities.Book;

public class BookMapper {

    public static BookDTO entityToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setBookId(book.getBookId());
        dto.setBookTitle(book.getBookTitle());
        dto.setBookPrice(book.getBookPrice());
        
        return dto;
    }

    public static Book dtoToEntity(BookDTO dto) {
        Book book = new Book();
        
        book.setBookId(dto.getBookId());
        book.setBookTitle(dto.getBookTitle());
        book.setBookPrice(dto.getBookPrice());
        
        return book;
    }
}