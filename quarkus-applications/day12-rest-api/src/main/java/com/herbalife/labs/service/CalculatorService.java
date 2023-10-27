package com.herbalife.labs.service;

import com.herbalife.labs.model.Calculator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CalculatorService {
    @Inject
    private Calculator calculator;

    public int square(int a) {
        return calculator.square(a);
    }

    public int product(int a, int b) {
        return calculator.multiply(a, b);
    }

    public int sum(int a, int b) {
        return calculator.add(a, b);
    }

    public List<String> getOperations() {
        return List.of("add", "subtract", "multiply", "square");
    }
}
