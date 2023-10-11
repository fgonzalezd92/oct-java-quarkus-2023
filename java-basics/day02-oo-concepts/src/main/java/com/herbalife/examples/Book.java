package com.herbalife.examples;

public class Book {
    private String title;
    private double price;
    private Publisher publisher;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
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
