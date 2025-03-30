package com.bookstore.controller;

import com.bookstore.dto.request.BookRequest;
import com.bookstore.dto.response.BookResponse;
import com.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequest bookRequest,
                                                 Authentication authentication) {
        return ResponseEntity.ok(bookService.createBook(bookRequest, authentication.getName()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id,
                                                 @Valid @RequestBody BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.updateBook(id, bookRequest));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getAllBooks(Pageable pageable) {
        return ResponseEntity.ok(bookService.getAllBooks(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<BookResponse>> searchBooks(@RequestParam String title,
                                                        Pageable pageable) {
        return ResponseEntity.ok(bookService.searchBooks(title, pageable));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Page<BookResponse>> getBooksByAuthor(@PathVariable String author,
                                                             Pageable pageable) {
        return ResponseEntity.ok(bookService.getBooksByAuthor(author, pageable));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<Page<BookResponse>> getBooksByCategory(@PathVariable String category,
                                                               Pageable pageable) {
        return ResponseEntity.ok(bookService.getBooksByCategory(category, pageable));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<Page<BookResponse>> getBooksByRating(@PathVariable Double rating,
                                                             Pageable pageable) {
        return ResponseEntity.ok(bookService.getBooksByRating(rating, pageable));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<BookResponse>> getBooksByFilters(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minRating,
            Pageable pageable) {
        return ResponseEntity.ok(bookService.getBooksByFilters(author, category, minRating, pageable));
    }
} 