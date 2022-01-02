package com.dk.bookReservation.controller;

import com.dk.bookReservation.dto.BookLendDto;
import com.dk.bookReservation.entity.Lend;
import com.dk.bookReservation.repository.LendRepository;
import com.dk.bookReservation.service.LendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/library")
@RequiredArgsConstructor
public class LendController {
    private final LendService lendService;

    @PostMapping("/book/lend")
    public ResponseEntity<List<String>> LendABook(@RequestBody BookLendDto bookLendDto){
        return ResponseEntity.ok(lendService.lendABook(bookLendDto));
    }
}
