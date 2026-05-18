package com.cognizant.lms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_dtls")
@Data
public class Book {
    @Id
    private Long bookId;
    private String bookTitle;
    private Double bookPrice;
}
