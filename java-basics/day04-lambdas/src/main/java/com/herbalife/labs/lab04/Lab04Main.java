package com.herbalife.labs.lab04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Lab04Main {
    private static List<City> cityList = new ArrayList<>();
    private static Map<String, List<City>> countryCitiesMap;

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/prabhu/Documents/cities.csv";
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        populateCityList(lines);
        printAllTheCitiesGroupedByCountries();
        printPopulationOf("China");
        printSmallestCity();
        printLargestCity();
    }

    private static void printLargestCity() {
        City largestCity = cityList.get(0);
        for (City city : cityList) {
            if (city.population() > largestCity.population()) {
                largestCity = city;
            }
        }
        System.out.println("Largest city is " + largestCity.name() + " with population " + largestCity.population());
    }

    private static void printSmallestCity() {
        City smallestCity = cityList.get(0);
        for (City city : cityList) {
            if (city.population() < smallestCity.population()) {
                smallestCity = city;
            }
        }
        System.out.println("Smallest city is " + smallestCity.name() + " with population " + smallestCity.population());
    }

    private static void printPopulationOf(String country) {
        int totalPopulation = 0;
        for (City city : cityList) {
            if (city.country().equals(country)) {
                totalPopulation += city.population();
            }
        }
        System.out.println("Total population of " + country + " is " + totalPopulation);
    }

    private static void printAllTheCitiesGroupedByCountries() {
        countryCitiesMap = new HashMap<>();
        for (City city : cityList) {
            if (countryCitiesMap.containsKey(city.country())) {
                countryCitiesMap.get(city.country()).add(city);
            } else {
                List<City> cities = new ArrayList<>();
                cities.add(city);
                countryCitiesMap.put(city.country(), cities);
            }
        }
        Set<String> countries = countryCitiesMap.keySet();
        for (String country : countries) {
            System.out.println("Country: " + country);
            List<City> cities = countryCitiesMap.get(country);
            for (City city : cities) {
                System.out.println("\t" + city.name() + " - " + city.population());
            }
        }
    }


    private static void populateCityList(List<String> lines) {
        for (String line : lines) {
            if (!line.startsWith("City")) {
                String[] tokens = line.split(",");
                City city = new City(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                cityList.add(city);
            }
        }

    }
}
