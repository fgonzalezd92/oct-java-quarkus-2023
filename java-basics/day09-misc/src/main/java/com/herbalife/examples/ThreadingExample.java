package com.herbalife.examples;

public class ThreadingExample {
    public static void main(String[] args) {
        //Creating a Thread in Java creates an OS thread
        //OS threads are expensive to create and destroy
        //Java threads are mapped to OS threads
        //Java threads are heavyweight

        //Golang threads are lightweight
        //Golang threads are called goroutines
        //Golang threads are managed by the Go runtime

        //Virtual threads are lightweight
        //Virtual threads are managed by the Java runtime
        //Virtual threads are similar to goroutines

        //OLD STYLE
        Thread waggingTailThread = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    System.out.println("Wagging tail...");
                    MyThreadUtil.sleep(1);
                }
            }
        });
        waggingTailThread.start();

        //NEW STYLE
        Thread walkingThread = new Thread(() -> {
            while(true) {
                System.out.println("Walking...");
                MyThreadUtil.sleep(2);
            }
        });
        walkingThread.start();
    }
}
