package com.herbalife.labs.lab09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lab09Main {
    private static List<String> lines = null;
    private static String cityInJson = """
            {
                "country": "%s",
                "city": "%s",
                "population": %s
            }
            """;

    public static void main(String[] args) throws IOException {
        String filePath = "cities.csv";
        lines = Files.readAllLines(Paths.get(filePath));
        storeDistinctCityNamesIn("cities.txt");
        storeDistinctCountryNamesIn("countries.txt");
        printCountOfCitiesGroupedByCountry();
        generateJson("places.json");
    }

    private static String convertToJson(String line) {
        String[] items = line.split(",");
        return cityInJson.formatted(items[0], items[1], items[2]);
    }

    private static void generateJson(String fileName) throws IOException {
        String json = lines
                .stream()
                .skip(1)
                .map(Lab09Main::convertToJson)
                .collect(Collectors.joining(",", "[", "]"));
        Files.write(Paths.get(fileName), json.getBytes());
    }

    private static void printCountOfCitiesGroupedByCountry() {
        Map<String, List<String>> countryCityListMap = lines
                .stream()
                .skip(1)
                .collect(Collectors.groupingBy(line -> line.split(",")[1]));
        countryCityListMap.forEach((country, values) -> {
            System.out.println("Country: %s, Cities count: %s".formatted(country, values.size()));
        });
    }


    private static void storeDistinctCountryNamesIn(String fileName) throws IOException {
        int separatorIndex = 1;
        Set countryNames = getItems(separatorIndex);
        Files.write(Paths.get(fileName), countryNames);
    }

    private static void storeDistinctCityNamesIn(String fileName) throws IOException {
        int separatorIndex = 0;
        Set cityNames = getItems(separatorIndex);
        Files.write(Paths.get(fileName), cityNames);
    }

    private static Set getItems(int separatorIndex) {
        Set items = lines
                .stream()
                .skip(1)
                .map(line -> line.split(",")[separatorIndex])
                .collect(Collectors.toSet());
        return items;
    }


}
