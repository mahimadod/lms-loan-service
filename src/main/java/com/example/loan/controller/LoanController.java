package com.example.loan.controller;

import com.example.loan.entity.Loan;
import com.example.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/loan-service/api/loans")
@CrossOrigin
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestParam Long memberId, @RequestBody List<Long> bookIds) {
        return ResponseEntity.ok(loanService.createLoan(memberId, bookIds));
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnLoan(@PathVariable Long loanId) {
        return ResponseEntity.ok(loanService.returnLoan(loanId));
    }

    @PutMapping("/{loanId}/extend")
    public ResponseEntity<Loan> extendLoan(@PathVariable Long loanId, @RequestParam String newDueDate) {
        return ResponseEntity.ok(loanService.extendLoan(loanId, LocalDate.parse(newDueDate)));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Loan>> getLoansByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(loanService.getLoansByMember(memberId));
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Loan>> getOverdueLoans() {
        return ResponseEntity.ok(loanService.getOverdueLoans());
    }
}
