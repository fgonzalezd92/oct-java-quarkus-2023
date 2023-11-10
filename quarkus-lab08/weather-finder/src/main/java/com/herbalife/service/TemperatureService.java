package com.herbalife.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herbalife.model.TemperatureData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

@ApplicationScoped
public class TemperatureService {
    @Inject
    private DataSource dataSource;

    @ConfigProperty(name = "weatherstack.url")
    private String weatherStackUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    public String fetchTemperatureFromWeatherStack(String city) throws IOException, InterruptedException {
        String url = weatherStackUrl + city;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void saveTemperature(String city, float temperature) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO temperatures(city, temperature, observation_date_time) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, city);
            statement.setFloat(2, temperature);
            statement.setObject(3, java.time.LocalDateTime.now());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public float parseTemperatureData(String json) throws JsonProcessingException {
        TemperatureData temperatureData = objectMapper.readValue(json, TemperatureData.class);
        return temperatureData.getCurrent().getTemperature();
    }
}
