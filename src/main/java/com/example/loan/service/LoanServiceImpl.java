package com.example.loan.service;

import com.example.loan.entity.Book;
import com.example.loan.entity.Loan;
import com.example.loan.entity.LoanItem;
import com.example.loan.entity.Member;
import com.example.loan.repository.LoanItemRepository;
import com.example.loan.repository.LoanRepository;
import com.example.loan.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanItemRepository loanItemRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Loan createLoan(Long memberId, List<Long> bookIds) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        Loan loan = Loan.builder()
                .member(memberOptional.get())
                .loanDate(LocalDate.now())
                .dueDate(LocalDate.now().plusWeeks(2))
                .build();

        Loan savedLoan = loanRepository.save(loan);

        for (Long bookId : bookIds) {
            LoanItem item = LoanItem.builder()
                    .loan(savedLoan)
                    .book(Book.builder()
                            .id(bookId)
                            .build())
                    .build();
            loanItemRepository.save(item);
        }

        return savedLoan;
    }

    @Override
    public Loan returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow();
        loan.setReturnDate(LocalDate.now());
        return loanRepository.save(loan);
    }

    @Override
    public Loan extendLoan(Long loanId, LocalDate newDueDate) {
        Loan loan = loanRepository.findById(loanId).orElseThrow();
        loan.setDueDate(newDueDate);
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getLoansByMember(Long memberId) {
        return loanRepository.findByMemberId(memberId);
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getOverdueLoans() {
        return loanRepository.findByDueDateBeforeAndReturnDateIsNull(LocalDate.now());
    }
}
