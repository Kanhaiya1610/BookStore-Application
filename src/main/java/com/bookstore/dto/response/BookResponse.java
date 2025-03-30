package com.bookstore.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String category;
    private Double price;
    private Double rating;
    private LocalDate publishedDate;
    private String createdByUsername;
} 