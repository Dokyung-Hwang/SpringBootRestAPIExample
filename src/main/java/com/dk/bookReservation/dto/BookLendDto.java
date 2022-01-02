package com.dk.bookReservation.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookLendDto {
    private List<Long> bookIds;
    private Long memberId;
}
