package com.example.loan.service;

import com.example.loan.entity.Loan;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
    Loan createLoan(Long memberId, List<Long> bookIds);
    Loan returnLoan(Long loanId);
    Loan extendLoan(Long loanId, LocalDate newDueDate);
    List<Loan> getLoansByMember(Long memberId);
    List<Loan> getAllLoans();
    List<Loan> getOverdueLoans();
}
