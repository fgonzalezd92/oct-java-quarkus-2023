package com.herbalife.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingStrategy {
    public static void main(String[] args) {
        //How many threads do you need?
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors: " + numberOfProcessors); //8 in my machine

        //CPU-Intensive tasks or IO-Intensive tasks?
        //Blocking factor = 0 < 1
        //CPU intensive tasks: Blocking factor = 0.1-0.4
        //IO intensive tasks: Blocking factor = 0.8-0.9 or 1

        //Number of threads = Number of processors / ( 1 - Blocking factor)

        //Process 1M items in a collection
        //Number of threads = 8 / (1 - 0.1) = 8 / 0.9 = 8.88 = 9 threads

        //Connect to 1000 servers
        //Number of threads = 8 / (1 - 0.9) = 8 / 0.1 = 80 threads

        double blockingFactor = 0.1; //CPU intensive task
        int numberOfThreads = (int)(numberOfProcessors / (1 - blockingFactor));
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);









    }
}
