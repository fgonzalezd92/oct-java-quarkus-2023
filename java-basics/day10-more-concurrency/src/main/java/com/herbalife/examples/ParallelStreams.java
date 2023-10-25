package com.herbalife.examples;

import java.util.List;

public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 45, 126, 23, 4, 99, 34, 12, 23, 45, 67, 89);
        //Print the square of all even numbers
        numbers
                .parallelStream() //creates number of threads equal to the (number of cores - 1)
                .filter(e -> {
                    System.out.println("**** Filtering " + e + " on " + Thread.currentThread().getName());
                    return e % 2 == 0;
                })
                .map(e -> {
                    System.out.println("**** Squaring " + e + " on " + Thread.currentThread().getName());
                    return e * e;
                })
                .forEach(e -> System.out.println(e + " on " + Thread.currentThread().getName()));
    }
}
