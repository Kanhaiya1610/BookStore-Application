package com.bookstore.service;

import com.bookstore.dto.request.BookRequest;
import com.bookstore.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookResponse createBook(BookRequest bookRequest, String username);
    BookResponse updateBook(Long id, BookRequest bookRequest);
    void deleteBook(Long id);
    BookResponse getBook(Long id);
    Page<BookResponse> getAllBooks(Pageable pageable);
    Page<BookResponse> searchBooks(String title, Pageable pageable);
    Page<BookResponse> getBooksByAuthor(String author, Pageable pageable);
    Page<BookResponse> getBooksByCategory(String category, Pageable pageable);
    Page<BookResponse> getBooksByRating(Double rating, Pageable pageable);
    Page<BookResponse> getBooksByFilters(String author, String category, Double minRating, Pageable pageable);
} 