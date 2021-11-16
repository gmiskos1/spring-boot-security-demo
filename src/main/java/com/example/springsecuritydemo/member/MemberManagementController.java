package com.example.springsecuritydemo.member;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/members")
public class MemberManagementController {
    private static final List<Member> MEMBERS = Arrays.asList(
            new Member(1, "George Miskos"),
            new Member(2, "Maria Miskou"),
            new Member(3, "Christos Iraklis")
    );

    // hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public static List<Member> getMEMBERS() {
        System.out.println("getMembers");
        return MEMBERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('member:write')")
    public void registerNewMember(@RequestBody Member member){
        System.out.println("registerNewMember");
        System.out.println(member);
    }

    @DeleteMapping(path = "{memberId}")
    @PreAuthorize("hasAuthority('member:write')")
    public void deleteMember(@PathVariable("memberId") Integer memberId){
        System.out.println("deleteMember");
        System.out.println(memberId);
    }

    @PutMapping(path = "{memberId}")
    @PreAuthorize("hasAuthority('member:write')")
    public void updateMember(@PathVariable("memberId") Integer memberId, @RequestBody Member member){
        System.out.println("updateMember");
        System.out.println(String.format("%s %s", memberId, member));
    }
}
