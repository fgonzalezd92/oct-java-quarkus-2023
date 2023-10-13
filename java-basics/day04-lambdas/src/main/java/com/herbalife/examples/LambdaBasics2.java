package com.herbalife.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class LambdaBasics2 {
    public static void main(String[] args) {

        Greetings greetings = name -> System.out.println("Hey " + name);
        greetings.hello("Sam");

        Greetings greetings1 = (String name) -> System.out.println("Hey " + name);
        greetings1.hello("Ram");

        Greetings greetings2 = name -> {
            System.out.println("Calling greetings");
            System.out.println("Wassup " + name);
        };
        greetings2.hello("Felipe");

        DateFetcher dateFetcher = () -> LocalDate.now().toString(); //return keyword is not required
        DateFetcher dateFetcher2 = () -> {
            return LocalDate.now().toString();
        };
        String date = dateFetcher.now();
        DateFetcher dateFetcher1 = () -> {
            System.out.println("Fetching date");
            return LocalDateTime.now().toString(); //return keyword is mandatory when you have a block of code
        };
    }
}

interface DateFetcher {
    String now();
}

@FunctionalInterface
interface Greetings {
    void hello(String name);
    //void bye(String name);
}
