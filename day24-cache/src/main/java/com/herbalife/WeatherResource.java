package com.herbalife;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Optional;

@ApplicationScoped
@Path("/weather")
public class WeatherResource {
    @Inject
    WeatherService weatherService;


    @GET
    @Path("/clear")
    public String clearCache() {
        weatherService.clearAllCache();
        return "Cache cleared";
    }


    @GET
    @Path("/{city}")
    public String getWeather(String city) {
        double temperature = weatherService.getWeather(city);
        return "The temperature in %s is %.2f degrees".formatted(city, temperature);
    }

    @GET
    @Path("/clear/{city}")
    public String clearCache(String city) {
        weatherService.clearCache(city);
        return "Cache cleared";
    }

}
