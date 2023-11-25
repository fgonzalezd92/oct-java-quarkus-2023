package com.herbalife.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    public int square(int a) {
        return a * a;
    }
}
