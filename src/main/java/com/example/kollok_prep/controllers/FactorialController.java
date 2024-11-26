package com.example.kollok_prep.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/factorials")
public class FactorialController {

    @GetMapping
    public ResponseEntity<List<Long>> getFactorials(@RequestParam int n) {
        if(n <= 0) return ResponseEntity.badRequest().body(null);

        List<Long> factorials = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            factorials.add(factorial(i));
        }
        return ResponseEntity.ok(factorials);

    }

    private long factorial(int number) {
        if (number == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
