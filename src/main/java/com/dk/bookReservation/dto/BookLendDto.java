package com.dk.bookReservation.dto;

import lombok.Data;

@Data
public class BookLendDto {
    private Long bookId;
    private Long memberId;
}
