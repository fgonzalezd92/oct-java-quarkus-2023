package com.herbalife.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ProgrammingStyle {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Clojure", "Java", "Erlang", "Golang", "JavaScript");
        //Print all the languages starting with letter J

        //Imperative style of programming
        //Verbosity;
        //Write code and say what to and also how to do
        //How do you make this code concurrent if it has 100K languages? Redesign this code
        for (int i = 0; i < languages.size(); i++) {
            String language = languages.get(i);
            if(language.startsWith("J")) {
                System.out.println(language);
            }
        }

        //Declarative style of programming (aka functional style of programming)
        //flows seamlessly; Readability
        //Data is not scattered everywhere
        //You write code and say what to DO
        //How do you make this code concurrent if it has 100K languages?
        languages
                .stream()
                //.parallel()
                //.filter(lang -> lang.startsWith("J"))
                .filter(new PredicateImpl())
                .forEach(System.out::println);
    }
}
class PredicateImpl implements Predicate<String> {
    @Override
    public boolean test(String str) {
        return str.startsWith("J");
    }
}