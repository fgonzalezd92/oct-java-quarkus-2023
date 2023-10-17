package com.herbalife.examples;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        //Consumer is a FI that consumes the data you provide. It doesn't return anything
        //forEach
        Consumer<String> printer = (value) -> System.out.println(value);
        printer.accept("Some data");

        Consumer<String> logger = value -> System.out.println("Logging " + value + " at " + Instant.now());
        logger.accept("XYZ called on SomeClass");
        List<String> langs = Arrays.asList("English", "Spanish");
        langs.forEach(printer);

        BiConsumer<Integer, Integer> biConsumer = (num1, num2) -> System.out.println(num1 + ", " + num2);
        biConsumer.accept(10, 12);
    }
}
