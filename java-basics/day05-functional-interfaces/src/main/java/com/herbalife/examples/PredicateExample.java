package com.herbalife.examples;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        //Predicate is a FI that takes value of ANY type and returns a BOOLEAN
        //In Stream API filter methods accept a Predicate as argument
        IntPredicate isOdd = num -> num % 2 != 0;
        DoublePredicate isPI = num -> num == 3.14;

        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10));
        int number = 11;
        //Check if number is odd
        isEven
                .negate()
                .test(number);

        Predicate<Integer> isGreaterThan100 = num -> num > 100;
        //check if number is even and also greater than 100
        isEven
                .and(isGreaterThan100)
                .test(number);

        Predicate<String> isBlank = value -> value.isBlank();
        System.out.println(isBlank.test(""));
    }
}

interface Tester {
    boolean test(Object object);
}
