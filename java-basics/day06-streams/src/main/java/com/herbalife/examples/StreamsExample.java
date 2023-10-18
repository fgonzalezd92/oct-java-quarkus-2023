package com.herbalife.examples;

import java.util.*;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        //Print all the numbers greater than 25

        //Stream is an abstraction of your collection
        //Stream is used to process a collection sequentially(by default)
        //Stream is used to read the items in a collection. You cannot modify the collection
        //Stream cannot be reused
        Stream<Integer> numbersStream = numbers.stream();
        numbersStream
                .filter(num -> num > 25)
                .forEach(num -> System.out.println(num));

        //ERROR; numbersStream cannot be reused as it has already been operated upon
//        numbersStream
//                .filter(num -> num > 10)
//                .forEach(num -> System.out.println(num));

        numbers
                .stream()
                .filter(num -> num > 10)
                .forEach(System.out::println);

        Set<String> langs = new HashSet<>();
        langs
                .stream()
                .filter(lang -> lang.startsWith("J"))
                .forEach(System.out::println);

        Map<Integer, String> romanNumbers = new HashMap<>();
        romanNumbers
                .forEach((key, value) -> System.out.println(key + ", " + value)); //forEach does not require a stream
        romanNumbers.keySet().stream();

    }
}
