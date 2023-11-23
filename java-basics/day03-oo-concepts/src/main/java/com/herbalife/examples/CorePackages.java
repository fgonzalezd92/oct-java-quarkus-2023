package com.herbalife.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class CorePackages {
    public static void main(String[] args) throws IOException {
        //java.lang is the base package which contains classes like String, Object, Exception etc
        //It's by default imported to our code

        //java.sql package is used to work with DB

        //java.util or java.time(latest) for working with time and date
        Date dt = new Date();
        LocalDate localDate = LocalDate.now();
        Calendar cldr = Calendar.getInstance(TimeZone.getTimeZone("en-US"));

        //java.net for remote access operations

        //java.io, java.nio
        List<String> lines = Files.readAllLines(Paths.get("~/readme.txt"));
        System.out.println(lines);

        //java.util contains all the collection classes
        //List, Set and Map
        //List<String> langs = new ArrayList<>(); //preserves order, allows duplication
        //List<String> langs = new Vector<>();
        List<String> langs = new LinkedList<>();
        langs.add("Java");
        langs.add("C#");
        langs.add("Golang");
        for (int i = 0; i < langs.size(); i++) {
            System.out.println(langs.get(i));
        }

        //Set does not allow duplication
        Set<String> cities = new HashSet<>();
        cities.add("Pune");
        cities.add("Mumbai");
        cities.add("Houston");
        cities.add("Pune");
        System.out.println(cities.size());

        Map<Integer, String> romanNumerals = new HashMap<>();
        romanNumerals.put(1, "I");
        romanNumerals.put(2, "II");
        romanNumerals.put(3, "III");
        Set<Integer> keys = romanNumerals.keySet();
        Iterator<Integer> keysIterator = keys.iterator();
        while(keysIterator.hasNext()) { //OLD STYLE OF CODING; Let's live with for a couple of days alone
            int key = keysIterator.next();
            String romanNumber = romanNumerals.get(key);
            System.out.println(romanNumber);
        }
    }
}
