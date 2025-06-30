package com.example.loan.service;

import java.util.Map;

public interface FineCalculationService {
    Map<Long, Double> calculateFines(Long memberId) throws Exception;
}