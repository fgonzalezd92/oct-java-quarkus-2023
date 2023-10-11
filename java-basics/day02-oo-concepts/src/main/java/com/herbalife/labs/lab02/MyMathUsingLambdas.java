package com.herbalife.labs.lab02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MyMathUsingLambdas {

    public int calculateSumOfOddNumbersBetween1To10001() {
//        int sum = 0;
//        for (int i = 0; i <= 10001; i++) {
//            if (i % 2 != 0) {
//                sum += i;
//            }
//        }
//        return sum;
        return IntStream
                .range(1, 10002)
                .filter(e -> e % 2 != 0)
                .sum();
    }

    public int calculateIntegerAverageOfNumbersBetween1To10001() {
        int sum = 0;
        for (int i = 0; i <= 10001; i++) {
            sum += i;
        }
        int[] exclusionList = {10, 19, 21, 39, 309, 431, 643, 942, 1209, 7981, 8888, 9910};
        for (int i = 0; i < exclusionList.length; i++) {
            sum -= exclusionList[i];
        }
        int average = sum / (10001 - exclusionList.length);
        return average;
    }

    public int sumOf(String input) {
        int sum = 0;
        String[] items = input.split(" ");
        return Arrays
                .stream(items)
                .map(e -> Integer.parseInt(e))
                .reduce((current, next) -> current + next)
                .get();

    }


}
