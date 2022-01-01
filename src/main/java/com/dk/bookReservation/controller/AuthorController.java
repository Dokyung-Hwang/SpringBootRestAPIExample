package com.dk.bookReservation.controller;

import com.dk.bookReservation.dto.AuthorDto;
import com.dk.bookReservation.entity.Author;
import com.dk.bookReservation.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/library")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorDto authorDto){
        return ResponseEntity.ok(authorService.createAuthor(authorDto));
    }

}
