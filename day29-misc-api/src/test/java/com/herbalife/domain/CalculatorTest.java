package com.herbalife.domain;

import domain.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertTrue(calculator.sum(1, 1) == 2);
    }

    @Test
    public void testSquare() {
        assertEquals(calculator.square(2), 4);
    }
}
