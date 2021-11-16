package com.example.springsecuritydemo.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    private static final List<Member> MEMBERS = Arrays.asList(
            new Member(1, "George Miskos"),
            new Member(2, "Maria Miskou"),
            new Member(3, "Christos Iraklis")
    );

    @GetMapping(path = "{memberId}")
    public Member getMember(@PathVariable("memberId") Integer memberId){
        return MEMBERS.stream()
                .filter(member -> memberId.equals(member.getMemberId()))
                .findFirst()
                .orElseThrow(
                ()-> new IllegalStateException("Member "+memberId+ " does not exist"));
    }
}
