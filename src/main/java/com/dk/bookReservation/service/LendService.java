package com.dk.bookReservation.service;

import com.dk.bookReservation.dto.BookLendDto;
import com.dk.bookReservation.entity.*;
import com.dk.bookReservation.repository.AuthorRepository;
import com.dk.bookReservation.repository.BookRepository;
import com.dk.bookReservation.repository.LendRepository;
import com.dk.bookReservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LendService {
    private final LendRepository lendRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<String> LendABook(List<BookLendDto> list){
        List<String> booksApprovedToInuse = new ArrayList<>();
        list.forEach(bookLendDto -> {
            Optional<Book> bookForId = bookRepository.findById(bookLendDto.getBookId());
            if (!bookForId.isPresent()) {
                throw new EntityNotFoundException("Can't find any book under given ID");
            }

            Optional<Member> memberForId = memberRepository.findById(bookLendDto.getMemberId());
            if (!memberForId.isPresent()) {
                throw new EntityNotFoundException("Member not present in the database");
            }

            Member member = memberForId.get();
            if (member.getStatus() != "ACTIVATE") {
                throw new RuntimeException("User is not activate to proceed a lending.");
            }

            Optional<Lend> inusedBook = lendRepository.findByBookAndStatus(bookForId.get(), LendStatus.INUSE);

            if (!inusedBook.isPresent()) {
                booksApprovedToInuse.add(bookForId.get().getName());
                Lend lend = new Lend();
                lend.setMember(memberForId.get());
                lend.setBook(bookForId.get());
                lend.setStatus(LendStatus.INUSE);
                lend.setStartOn(Instant.now());
                lend.setDueOn(Instant.now().plus(30, ChronoUnit.DAYS));
                lendRepository.save(lend);
            }
        });
        return booksApprovedToInuse;
    }
}
