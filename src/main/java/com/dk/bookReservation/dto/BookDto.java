package com.dk.bookReservation.dto;

import lombok.Data;

@Data
public class BookDto {
    private String name;
    private String isbn;
    private Long authorId;
}
