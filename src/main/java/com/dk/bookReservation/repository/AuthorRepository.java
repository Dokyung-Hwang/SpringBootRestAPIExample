package com.dk.bookReservation.repository;

import com.dk.bookReservation.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
