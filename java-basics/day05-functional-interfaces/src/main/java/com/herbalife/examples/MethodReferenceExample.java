package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceExample {
    public static void main(String[] args) {
        //similar to scope operator in C++ ::
        //It's a shortcut for lambda expressions

        Predicate<Integer> isEven = num -> num % 2 == 0;
        isEven.test(12);

//        Predicate<Integer> isOdd = num -> {
//            System.out.println("Calling isOdd for " + num);
//            boolean condition = num % 2 != 0;
//            return condition;
//        };
        Predicate<Integer> isOdd = MethodReferenceExample::checkOdd;
        isOdd.test(12);

        Calculator calculator = new Calculator();
        //BiFunction<Integer, Integer, Integer>  adder = (num1, num2) -> num1 + num2;
        BiFunction<Integer, Integer, Integer> adder = calculator::add;
        adder.apply(12, 12);

        List<String> cities = Arrays.asList("Chennai", "LA");
        //cities.forEach(city -> System.out.println(city));
        cities.forEach(System.out::println);

        Function<String, Integer> length = value -> value.length();
        Function<String, Integer> lengthFunction = String::length;
        Function<String, String> toCaps = String::toUpperCase;
        toCaps.apply("hello");
    }

    static boolean checkOdd(int num) {
        System.out.println("Calling isOdd for " + num);
        boolean condition = num % 2 != 0;
        return condition;
    }
}

class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }
}
