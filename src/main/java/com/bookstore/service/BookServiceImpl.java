package com.bookstore.service;

import com.bookstore.dto.request.BookRequest;
import com.bookstore.dto.response.BookResponse;
import com.bookstore.model.Book;
import com.bookstore.model.User;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public BookResponse createBook(BookRequest bookRequest, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setCategory(bookRequest.getCategory());
        book.setPrice(bookRequest.getPrice());
        book.setRating(bookRequest.getRating());
        book.setPublishedDate(bookRequest.getPublishedDate());
        book.setCreatedBy(user);

        Book savedBook = bookRepository.save(book);
        return convertToResponse(savedBook);
    }

    @Override
    @Transactional
    public BookResponse updateBook(Long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setCategory(bookRequest.getCategory());
        book.setPrice(bookRequest.getPrice());
        book.setRating(bookRequest.getRating());
        book.setPublishedDate(bookRequest.getPublishedDate());

        Book updatedBook = bookRepository.save(book);
        return convertToResponse(updatedBook);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }

    @Override
    public BookResponse getBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        return convertToResponse(book);
    }

    @Override
    public Page<BookResponse> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(this::convertToResponse);
    }

    @Override
    public Page<BookResponse> searchBooks(String title, Pageable pageable) {
        return bookRepository.searchByTitle(title, pageable).map(this::convertToResponse);
    }

    @Override
    public Page<BookResponse> getBooksByAuthor(String author, Pageable pageable) {
        return bookRepository.findByAuthorContainingIgnoreCase(author, pageable).map(this::convertToResponse);
    }

    @Override
    public Page<BookResponse> getBooksByCategory(String category, Pageable pageable) {
        return bookRepository.findByCategoryContainingIgnoreCase(category, pageable).map(this::convertToResponse);
    }

    @Override
    public Page<BookResponse> getBooksByRating(Double rating, Pageable pageable) {
        return bookRepository.findByRatingGreaterThanEqual(rating, pageable).map(this::convertToResponse);
    }

    @Override
    public Page<BookResponse> getBooksByFilters(String author, String category, Double minRating, Pageable pageable) {
        return bookRepository.findByFilters(author, category, minRating, pageable).map(this::convertToResponse);
    }

    private BookResponse convertToResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setCategory(book.getCategory());
        response.setPrice(book.getPrice());
        response.setRating(book.getRating());
        response.setPublishedDate(book.getPublishedDate());
        response.setCreatedByUsername(book.getCreatedBy().getUsername());
        return response;
    }
} 