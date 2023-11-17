package com.herbalife;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheKey;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WeatherService {



    @CacheResult(cacheName = "weather")
    public double getWeather(@CacheKey String city) {
        double temperature = connectToWeatherApi(city);
        return temperature;
    }

    private double connectToWeatherApi(String city) {
        System.out.println("==== Connecting to weather API...%s".formatted(city));
        //Simulate a delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Math.random() * 100;
    }

    @CacheInvalidateAll(cacheName = "weather")
    public void clearAllCache() {
        System.out.println("------- Clearing all cache");
    }

    @CacheInvalidate(cacheName = "weather")
    public void clearCache(String city) {
        System.out.println("------- Clearing cache for %s".formatted(city));
    }
}
