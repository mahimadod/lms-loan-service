package com.example.loan.service;


import com.example.loan.entity.Member;
import java.util.Optional;

public interface MemberService {
    Optional<Member> getMemberById(Long memberId);
}
