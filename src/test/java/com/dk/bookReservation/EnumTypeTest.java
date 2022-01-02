package com.dk.bookReservation;


import com.dk.bookReservation.dto.MemberDto;
import com.dk.bookReservation.entity.*;
import com.dk.bookReservation.repository.LendRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Transactional
@SpringBootTest
class EnumTypeTest {



    @Autowired
    private LendRepository lendRepository;


    @Test
    void saveLendTest() {
        Lend newLend = new Lend();
        Member member = new Member();
        Book book = new Book();
        // newLend.setStatus(LendStatus.TEST);
        newLend.setDueOn(Instant.now());
        newLend.setStartOn(Instant.now());
        newLend.setId(book.getId());


        newLend = lendRepository.save(newLend);
        // assertEquals(LendStatus.TEST, newLend.getStatus());
    }

}