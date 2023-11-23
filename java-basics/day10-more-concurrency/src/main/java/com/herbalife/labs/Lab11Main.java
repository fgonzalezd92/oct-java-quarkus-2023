package com.herbalife.labs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Lab11Main {
    public static final String OMDB_API_URL = "http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=";
    static List<String> movieNames = null;
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        movieNames = Files.readAllLines(Paths.get("./movies.txt"));

        CompletableFuture
                .supplyAsync(() -> {
                    Map<String, List<Movie>> movieDetailsMap = movieNames
                            .parallelStream()
                            .map(Lab11Main::getMovieDetailsFromOmdb)
                            .collect(Collectors.groupingBy(Movie::getResponse));
                    return movieDetailsMap;
                })
                .thenAccept(movieDetailsMap -> {
                    movieDetailsMap.forEach((response, movies) -> {
                        if ("False".equalsIgnoreCase(response)) {
                            System.out.println("=== Error while fetching movie details for below movies ===");
                            movies.forEach(movie -> System.out.println(movie.getTitle() + " : " + movie.getError()));
                        } else {
                            movies.forEach(System.out::println);
                        }
                    });
                });
        System.out.println("**** Movies are being fetched ****");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Movie getMovieDetailsFromOmdb(String movie) {
        Movie movieDetails = null;
        try {
            String url = OMDB_API_URL + URLEncoder.encode(movie, "UTF-8");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(java.net.URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();
            movieDetails = mapper.readValue(jsonResponse, Movie.class);
            if ("False".equalsIgnoreCase(movieDetails.getResponse())) {
                movieDetails.setTitle(movie);
            }
        } catch (IOException | InterruptedException e) {
            movieDetails = new Movie();
            movieDetails.setResponse("False");
            movieDetails.setError(e.getMessage());
            movieDetails.setTitle(movie);
        }
        return movieDetails;
    }
}
