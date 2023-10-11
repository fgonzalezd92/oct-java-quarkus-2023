package com.herbalife.examples;

public class OOBasics {
    public static void main(String[] args) {
        Car bmw = new Car();
        bmw.setModel("BMW");
        bmw.setYearOfMake(2023);
        bmw.drive(100);

        Book b1 = new Book("Programming Ruby", 12.34);
        Publisher publisher = new Publisher("Apress");
        b1.setPublisher(publisher);
        System.out.println(b1);
    }
}
