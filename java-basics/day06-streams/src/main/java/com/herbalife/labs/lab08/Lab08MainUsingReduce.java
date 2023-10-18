package com.herbalife.labs.lab08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab08MainUsingReduce {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("Nike", 20.45),
                new Item("Power", 31.45),
                new Item("Adidas", 31.45),
                new Item("Reebok", 29.25),
                new Item("Puma", 25.15),
                new Item("Fila", 15.15));

        //Print the name and price of the costliest shoe
        Item costliestItem = items
                .stream()
                .reduce((currentItem, nextItem) -> currentItem.getPrice() >= nextItem.getPrice() ? currentItem : nextItem)
                .get();
        System.out.println(costliestItem);

        //Print the name and price of the costliest shoe
        Item cheapestItem = items
                .stream()
                .reduce((currentItem, nextItem) -> currentItem.getPrice() < nextItem.getPrice() ? currentItem : nextItem)
                .get();
        System.out.println(cheapestItem);

        //Concatenate all the item names using comma and print the value
        String names = items
                .stream()
                //.map(item -> item.getName())
                .map(Item::getName)
                .collect(Collectors.joining(","));
        System.out.println(names);
    }
}
