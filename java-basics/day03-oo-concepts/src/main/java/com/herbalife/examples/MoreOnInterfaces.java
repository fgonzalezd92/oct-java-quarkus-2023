package com.herbalife.examples;

import java.time.Instant;

public class MoreOnInterfaces {
    public static void main(String[] args) {
        Printer.turnOn();
        System.out.println(Printer.TYPE);
        MyPrinter myPrinter = new MyPrinter();
        myPrinter.print("some data");
        myPrinter.printCurrentDate();
        System.out.println(MyPrinter.TYPE);
    }
}
class MyPrinter implements Printer {
    @Override
    public void print(String data) {

    }
//
//    @Override
//    public void printCurrentDate() {
//        Printer.super.printCurrentDate(); //WEIRD
//    }
}

interface Printer {
    String TYPE = "Samsung";

    void print(String data);

    default void printCurrentDate() {
        System.out.println(Instant.now());
    }

    static void turnOn() {
        System.out.println("turning printer on");
    }
}
