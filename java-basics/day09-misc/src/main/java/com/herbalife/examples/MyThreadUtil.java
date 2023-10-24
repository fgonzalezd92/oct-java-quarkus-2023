package com.herbalife.examples;

public class MyThreadUtil {
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
