package com.example.loan.controller;

import com.example.loan.service.FineCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/loan-service/api/fines")
public class FineCalculationController {

    @Autowired
    private FineCalculationService fineService;

    @GetMapping("/calculate/{memberId}")
    public ResponseEntity<Map<Long, Double>> calculateFines(@PathVariable Long memberId) throws Exception {
        Map<Long, Double> fines = fineService.calculateFines(memberId);
        return ResponseEntity.ok(fines);
    }
}