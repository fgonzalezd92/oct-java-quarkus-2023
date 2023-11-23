package com.herbalife.examples;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        //Generics in Java is compile time enforcement of type safety

        List<String> list = List.of("a", "b", "c");
        //list.add(100);
        MyCollection<String> words = new MyCollection<>();
        words.add("a");
        words.add("b");
        //System.out.println(MyCollection.count); //MyCollection<String> in .NET
        System.out.println(words.getClass().getName()); //MyCollection<String> in .NET

        MyCollection<Integer> numbers = new MyCollection<>();
        numbers.add(1);
        numbers.add(2);
        //System.out.println(MyCollection.count);//MyCollection<Integer> in .NET
        System.out.println(numbers.getClass().getName());//MyCollection<Integer> in .NET

        MovieCollection<CD> cdCollection = new MovieCollection<>(new CD());
        MovieCollection<DVD> dvdCollection = new MovieCollection<>(new DVD());
        //MovieCollection<String> stringCollection = new MovieCollection<>("a"); //String is not a subtype of Entertainment

    }
}


interface Entertainment {}
class CD implements Entertainment {}
class DVD implements Entertainment {}
class MovieCollection<T extends Entertainment> {
    private T item;
    public MovieCollection(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}
class MyCollection<T> {
    public static int count = 0;
    public MyCollection() {
        count++;
    }
    private List<T> items = new ArrayList<>();
    public void add(T item) {
        items.add(item);
    }
}
