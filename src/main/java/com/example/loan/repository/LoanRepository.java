package com.example.loan.repository;

import com.example.loan.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberId(Long memberId);
    List<Loan> findByDueDateBeforeAndReturnDateIsNull(LocalDate date);
    List<Loan> findByMemberIdAndReturnDateIsNotNull(Long memberId);
}
