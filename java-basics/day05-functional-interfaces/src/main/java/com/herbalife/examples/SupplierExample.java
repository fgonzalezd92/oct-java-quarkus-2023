package com.herbalife.examples;

import java.time.LocalTime;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        //Supplier is a FI that supplies data; It does not accept any data
        IntSupplier randomNumberSupplier = () -> (int) (Math.random() * 100);
        Supplier<Integer> randomSupplier = () -> (int) (Math.random() * 100);
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());

        Supplier<LocalTime> now = () -> LocalTime.now();
        System.out.println(now.get().toString());

        Supplier<MyData> myData = () -> new MyData();
    }
}

class MyData {
    int value1;
    double value2;
}