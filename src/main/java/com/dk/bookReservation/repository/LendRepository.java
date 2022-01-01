package com.dk.bookReservation.repository;

import com.dk.bookReservation.entity.Book;
import com.dk.bookReservation.entity.Lend;
import com.dk.bookReservation.entity.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}
