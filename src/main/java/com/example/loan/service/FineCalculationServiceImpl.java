package com.example.loan.service;

import com.example.loan.entity.Loan;
import com.example.loan.repository.LoanItemRepository;
import com.example.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FineCalculationServiceImpl implements FineCalculationService{

    @Autowired
    private LoanRepository loanRepo;
    @Autowired
    private LoanItemRepository loanItemRepo;
    @Autowired
    private FineStrategyContext fineStrategyContext;

    public Map<Long, Double> calculateFines(Long memberId) throws Exception {
        List<Loan> loans = loanRepo.findByMemberIdAndReturnDateIsNotNull(memberId);
        Map<Long, Double> fineMap = new HashMap<>();
        for (Loan loan : loans) {
            long daysLate = ChronoUnit.DAYS.between(loan.getDueDate(), loan.getReturnDate());
            if (daysLate > 0) {
                FineStrategy strategy = fineStrategyContext.getStrategy(loan.getMember().getId());
                double fine = strategy.calculateFine(daysLate);
                fineMap.put(loan.getId(), fine);
            }
        }
        return fineMap;
    }
}