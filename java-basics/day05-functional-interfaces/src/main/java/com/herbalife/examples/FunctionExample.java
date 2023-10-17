package com.herbalife.examples;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionExample {
    public static void main(String[] args) {
        //Function is a FI that accepts data of ANY type and returns value of ANY type
        //In Stream API, map, reduce, collect accept Function as arguments
        BinaryOperator<Integer> add = (num1, num2) -> num1 + num2;
        BinaryOperator<String> concat = (value1, value2) -> value1.concat(value2);
        concat.apply("hello", "world");

        IntFunction<Integer> increment = num -> num + 1;
        Function<Integer, Integer> inc = num -> num + 1;
        System.out.println(inc.apply(10));

        Function<String, Integer> length = value -> value.length();
        System.out.println(length.apply("some string"));

        Function<Integer, Boolean> isEven = num -> num % 2 == 0; //Use Predicate instead
        isEven.apply(12);

        //increment a number and get the square of it
        Function<Integer, Integer> square = num -> num * num;
        int number = 10;
        int result = inc
                .andThen(square)
                .andThen(inc)
                .andThen(square)
                .apply(number);
        System.out.println(result);

        System.out.println(inc
                .compose(square)
                .apply(number));

    }
}
