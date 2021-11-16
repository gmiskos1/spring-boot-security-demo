package com.example.springsecuritydemo.member;

public class Member {
    private final Integer memberId;
    private final String memberName;

    public Member(Integer memberId,
                  String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
