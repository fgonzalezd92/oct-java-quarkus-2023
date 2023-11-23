package com.herbalife.examples;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Let's talk about Future");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> randomNumberFuture = executorService.submit(() -> {
            int count = 0;
            while(count < 5) {
                System.out.println("Generating a random number...");
                MyThreadUtil.sleep(1);
                count++;
            }
            return (int)(Math.random() * 100);
        });
        System.out.println("***Checking if the random number is ready...");
        //int randomNumber = randomNumberFuture.get(); //Blocking call
        while(!randomNumberFuture.isDone()) {
            System.out.println("***Random number is not ready yet...");
            MyThreadUtil.sleep(1);
        }
        System.out.println("End of main method");
        System.out.println("Random number is " + randomNumberFuture.get());
        executorService.shutdown();




//        executorService.submit(() -> {
//            while(true) {
//                System.out.println("Writing code on " + Thread.currentThread().getName());
//                MyThreadUtil.sleep(1);
//            }
//        });

    }
}
