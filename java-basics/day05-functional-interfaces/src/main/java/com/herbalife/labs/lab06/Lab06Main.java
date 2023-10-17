package com.herbalife.labs.lab06;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

public class Lab06Main {
    public static void main(String[] args) {
        IntBinaryOperator adder = (num1, num2) -> num1 + num2;
        UnaryOperator<Integer> square = num -> num * num;
    }
    static void operate(IntBinaryOperator binaryOperator) {
        System.out.println(binaryOperator.applyAsInt(5, 10));
    }
    static void compute(UnaryOperator<Integer> unaryOperator) {
        System.out.println(unaryOperator.apply(10));
    }
}
