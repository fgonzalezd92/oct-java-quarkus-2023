package com.herbalife.examples;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
         Supplier task = () -> {
            int count = 0;
            while(count < 5) {
                System.out.println("Generating a random number...");
                MyThreadUtil.sleep(1);
                count++;
            }
            return (int)(Math.random() * 100);
        };

         //You get an order for say 10 Printers
        //You connect to the Warehouse and ask for 10 Printers
        //If the warehouse responds with true
        //Place an order to the Packaging Unit
        //Place an order to the Shipping Unit

        //Generate code using CompletableFuture for the above



         //Similar to Promise in JavaScript
        CompletableFuture
                .supplyAsync(task, executorService) //Non-blocking call
                .thenAccept(value -> System.out.println("Random number is " + value))
                .thenAccept(value -> System.out.println("End of completable future"))
                .join(); //Blocking call, waits for the task to complete; Similar to using Future.get()

        System.out.println("******End of main method");


    }
}
