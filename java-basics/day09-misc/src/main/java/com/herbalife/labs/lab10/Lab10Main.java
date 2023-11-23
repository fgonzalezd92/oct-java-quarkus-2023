package com.herbalife.labs.lab10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Lab10Main {
    public static final String OMDB_API_URL = "http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=";
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        System.out.println("Enter a movie name");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.next();
        String movieDetails = getMovieDetailsFromOmdb(movieName);
        Movie movie = parseMovieDetailsJson(movieDetails);
        storeMovieInDb(movie);
        System.out.println("Stored " + movie + " in DB");
        scanner.close();
    }

    private static void storeMovieInDb(Movie movie) throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
            String sql = "insert into movies(title, year, language, genre) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getYear());
            preparedStatement.setString(3, movie.getLanguage());
            preparedStatement.setString(4, movie.getGenre());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }


    private static Movie parseMovieDetailsJson(String movieDetails) throws JsonProcessingException {
        Movie movie = objectMapper.readValue(movieDetails, Movie.class);
        return movie;
    }

    private static String getMovieDetailsFromOmdb(String movie) throws IOException, InterruptedException {
        String url = OMDB_API_URL + URLEncoder.encode(movie, "UTF-8");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(java.net.URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
