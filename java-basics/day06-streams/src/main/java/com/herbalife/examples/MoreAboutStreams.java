package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;

public class MoreAboutStreams {
    public static void main(String[] args) {
        List<String> langs = Arrays.asList("Java", "Golang", "Python", "C#", "Ruby");
        //Print the languages that begin with letter P
        //Streams are lazily evaluated
        langs
                .stream()
                .filter(lang -> {
                    System.out.println("***Checking " + lang);
                    return lang.startsWith("P");
                });
        //Streams are evaluated only when the terminal operation is encountered
        langs
                .stream()
                .filter(lang -> {
                    System.out.println("***Checking " + lang);
                    return lang.startsWith("P");
                })
                .forEach(System.out::println);


    }
}
