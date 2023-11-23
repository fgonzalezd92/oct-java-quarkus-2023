package com.herbalife.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ThreadPools {
    public static void main(String[] args) {
        //Create a thread pool, by specifying the number of threads
        //pick up a thread from the pool
        //execute a task using that thread

        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ForkJoinPool executorService = ForkJoinPool.commonPool(); //The threads terminate when main terminates

        Runnable codingTask = () -> {
            while(true) {
                System.out.println("Coding and committing changes... on " + Thread.currentThread().getName());
                MyThreadUtil.sleep(3);
            }
        };
        executorService.submit(codingTask);

        Runnable browsingTask = () -> {
            int count = 0;
            while(count < 5) {
                System.out.println("Browsing... on " + Thread.currentThread().getName());
                MyThreadUtil.sleep(4);
                count++;
            }
        };
        executorService.submit(browsingTask);

        Runnable eatingTask = () -> {
            while(true) {
                System.out.println("Eating... on " + Thread.currentThread().getName());
                MyThreadUtil.sleep(5);
            }
        };
        executorService.submit(eatingTask);

        MyThreadUtil.sleep(100); //Required for ForkJoinPool
    }
}
