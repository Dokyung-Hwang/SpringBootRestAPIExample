package com.dk.bookReservation.controller;

import com.dk.bookReservation.dto.BookDto;
import com.dk.bookReservation.entity.Book;
import com.dk.bookReservation.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/library")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/book")
    public ResponseEntity readBooks(@RequestParam(required = false) String isbn) {
        if (isbn == null){
            return ResponseEntity.ok(bookService.readBooks());
        }
        return ResponseEntity.ok(bookService.readBook(isbn));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> readBook(@PathVariable Long bookId){
        return ResponseEntity.ok(bookService.readBook(bookId));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.createBook(bookDto));
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook (@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
