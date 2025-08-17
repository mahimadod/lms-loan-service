package com.example.loan.service;
import com.example.exception_handler.LMSServiceException;
import com.example.loan.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FineStrategyContext {
    private final Map<String, FineStrategy> strategies;

    @Autowired
    private MemberService memberService;

    public FineStrategyContext(List<FineStrategy> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(s -> s.getClass().getAnnotation(Component.class).value(), s -> s));
    }

    public FineStrategy getStrategy(Long memberId) throws Exception {
        Optional<Member> member=memberService.getMemberById(memberId);
        if(member.isPresent()){
        return strategies.get(member.get().getStatus());
        }else{
            throw new LMSServiceException(HttpStatus.NOT_FOUND,"no member found");
        }
    }
}