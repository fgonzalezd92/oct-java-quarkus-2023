package com.herbalife.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 45, 126, 23, 4, 99, 34, 12, 23, 45, 67, 89);

        for (int i = 0; i < 10; i++) {

            List<Integer> resultList = new ArrayList<>(); //not thread safe
            numbers
                    .parallelStream()
                    .map(e -> e % e)
                    //.collect(Collectors.toList());
                    .forEach(e -> {
                        resultList.add(e); //DANGER; Ticking timebomb
                    });

            System.out.println("Numbers: " + numbers.size());
            System.out.println("Result " + resultList.size()); //at times this will be less than 12
        }

    }
}
