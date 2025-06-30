package com.example.loan.service;

import org.springframework.stereotype.Component;

@Component("STUDENT")
public class StudentFineStrategy implements FineStrategy {
    public double calculateFine(long daysLate) {
        return daysLate * 200;
    }
}