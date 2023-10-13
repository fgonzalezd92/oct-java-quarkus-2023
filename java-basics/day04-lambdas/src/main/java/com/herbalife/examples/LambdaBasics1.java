package com.herbalife.examples;

public class LambdaBasics1 {
    public static void main(String[] args) {
        Printer oldStylePrinter = new PrinterImpl();
        oldStylePrinter.print("hello");

        //Anonymous inner class; A class with no name
        Printer latestPrinter = new Printer(){
            public void print(String data) {
                System.out.println(data);
            }
        };
        Printer latestPrinter2 = new Printer(){
            public void print(String data) {
                System.out.println(data);
            }
        };
        latestPrinter.print("hi");

        //Can't we shorten this anonymous inner class also?
        //Lambda expression is an implementation of an interface with ONLY ONE 'abstract' method
        Printer modernPrinter = data -> System.out.println(data); //Lambda expression
        modernPrinter.print("Wassup");
        System.out.println(modernPrinter.getClass().getName());
    }
}
//An interface with just ONE abstract method is called FunctionalInterface
interface Printer {
    void print(String data);
    default void doSomething() {}
    static void doSomethingElse() {}
}
class PrinterImpl implements Printer {
    public void print(String data) {
        System.out.println(data);
    }
}
