package com.cognizant.lms.dtos;

import lombok.Data;

@Data
public class BookDTO {
    private Long bookId;
    private String bookTitle;
    private Double bookPrice;
}
