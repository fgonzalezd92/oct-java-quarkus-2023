package com.herbalife.examples;

public class Book {
    private String title;
    private double price;
    private Publisher publisher;

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public void buy(String store) {
        System.out.println("Buying %s from %s".formatted(this.title, store));
    }

    public void buy(String store, int quantity) {
        System.out.println("Buying %s quantities of %s from %s".formatted(quantity, this.title, store));
    }


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", publisher=" + publisher +
                '}';
    }
}
