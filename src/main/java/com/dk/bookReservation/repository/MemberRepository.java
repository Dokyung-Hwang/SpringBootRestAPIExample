package com.dk.bookReservation.repository;

import com.dk.bookReservation.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
