package com.dk.bookReservation.dto;

import lombok.Data;

@Data
public class BookLendDto {
    private Long book_Id;
    private Long member_Id;
}
