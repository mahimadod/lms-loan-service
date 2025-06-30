package com.example.loan.service;

import org.springframework.stereotype.Component;

@Component("FACULTY")
public class FacultyFineStrategy implements FineStrategy {
    public double calculateFine(long daysLate) {
        return daysLate * 100;
    }
}