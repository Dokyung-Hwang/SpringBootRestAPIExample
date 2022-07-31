package com.dk.bookReservation.controller;

import com.dk.bookReservation.dto.MemberDto;
import com.dk.bookReservation.entity.Member;
import com.dk.bookReservation.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity getMembers(@RequestParam(required = false) String id) {
        if (id == null){
            return ResponseEntity.ok(memberService.readMembers());
        }
        return ResponseEntity.ok(memberService.readMembers());
    }


    @PostMapping("/member")
    private ResponseEntity<Member> createMember (@RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(memberService.createMember(memberDto));
    }

    @PatchMapping("/member/{memberId}")
    public ResponseEntity<Member> updateMember(@RequestBody MemberDto memberDto, @PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.updateMember(memberId, memberDto));
    }

}
