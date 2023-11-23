package com.herbalife.examples;

public class OOBasics {
    public static void main(String[] args) {
        //cmd+option L to keep formatting the code
        Car bmw = new Car();
        bmw.setModel("BMW");
        bmw.setYearOfMake(2023);
        bmw.drive(100);

        Book b1 = new Book("Programming Ruby", 12.34);
        Publisher publisher = new Publisher("Apress");
        b1.setPublisher(publisher);
        System.out.println(b1);
        b1.buy("Flipkart");
        b1.buy("Amazon", 12);

        Book b2 = new Book("Scala", 12.56);
        System.out.println(b2);
    }
}
