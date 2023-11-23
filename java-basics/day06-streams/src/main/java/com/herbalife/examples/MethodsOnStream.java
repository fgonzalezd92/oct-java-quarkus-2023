package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodsOnStream {
    public static void main(String[] args) {
        List<String> langs = Arrays.asList("Java", "Golang", "Python", "C#", "Ruby");
        //All the methods on stream API address a single item only and not the collection
        //filter
        //It takes a collection of size n and applies the Predicate on each item and returns a collection of size 0 ..n
        langs
                .stream()
                .filter(lang -> lang.startsWith("P"))
                .forEach(lang -> System.out.println(lang));


        //map
        //It takes a collection of size n and applies the Function on each items and returns a collection of size n

        //Print all the items in UpperCase
        langs
                .stream()
                .map(lang -> lang.toUpperCase())
                .forEach(System.out::println);

        //Print all the items that start with P in UpperCase
        langs
                .stream()
                .filter(lang -> lang.startsWith("P"))
                .map(lang -> lang.toUpperCase())
                .forEach(System.out::println);


        //Generate a new list of langs in uppercase
        List<String> langsInUpperCase = langs
                .stream()
                .map(lang -> lang.toUpperCase())
                .collect(Collectors.toList());
        langsInUpperCase.forEach(System.out::println);






    }
}
