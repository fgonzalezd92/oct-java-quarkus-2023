package com.herbalife.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingWithJson {
    private static List<String> lines = null;
    public static void main(String[] args) throws IOException {
        String filePath = "cities.csv";
        lines = Files.readAllLines(Paths.get(filePath));
        List<City> cityList = lines
                .stream()
                .skip(1)
                .map(line -> new City(line.split(",")[0], line.split(",")[1], Long.parseLong(line.split(",")[2])))
                .collect(Collectors.toList());
        cityList.forEach(System.out::println);

        //convert cityList to Json
        //you need to use a particular library;
        //where do you look for the library. From a central repository called Maven repository
        ObjectMapper objectMapper = new ObjectMapper();
        

    }
}
