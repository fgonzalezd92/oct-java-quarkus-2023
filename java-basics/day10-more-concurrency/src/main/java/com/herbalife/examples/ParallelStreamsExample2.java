package com.herbalife.examples;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelStreamsExample2 {
    public static void main(String[] args) {
        IntStream numbersStream = IntStream.range(1, 1000);
        ForkJoinPool forkJoinPool = new ForkJoinPool(90); //based on the number of cores and intensity of the task
        forkJoinPool.submit(() -> {
            int result = numbersStream
                    .parallel() //by default creates number of threads equal to the (number of cores - 1)
                    .filter(e -> {
                        System.out.println("**** Filtering " + e + " on " + Thread.currentThread().getName());
                        MyThreadUtil.sleep(1);
                        return e % 2 == 0;
                    })
                    .map(e -> {
                        System.out.println("**** Squaring " + e + " on " + Thread.currentThread().getName());
                        MyThreadUtil.sleep(1);
                        return e * e;
                    })
                    .findAny()
                    .getAsInt();
            System.out.println(result);
            //.forEach(e -> System.out.println(e + " on " + Thread.currentThread().getName()));
        });

        MyThreadUtil.sleep(1000); //wait for the task to complete
    }
}
