package com.dk.bookReservation.service;

import com.dk.bookReservation.dto.MemberDto;
import com.dk.bookReservation.entity.Book;
import com.dk.bookReservation.entity.Member;
import com.dk.bookReservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> readMembers(){
        return memberRepository.findAll();
    }


    public Member createMember(MemberDto memberDto) {
        Member member = new Member();
        BeanUtils.copyProperties(memberDto, member);
        return memberRepository.save(member);
    }

    public Member updateMember (Long id, MemberDto memberDto) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()){
            throw new EntityNotFoundException("Member not present in the database");
        }

        Member member = new Member();
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        return memberRepository.save(member);
    }
}
