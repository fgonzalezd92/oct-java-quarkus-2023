package com.herbalife.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import com.herbalife.service.TemperatureService;

import java.io.IOException;

@ApplicationScoped
public class CityConsumer {
    @Inject
    private TemperatureService temperatureService;

    @Incoming("weather-in")
    public void consume(String city) throws IOException, InterruptedException {
        String json = temperatureService.fetchTemperatureFromWeatherStack(city);
        float temperature = temperatureService.parseTemperatureData(json);
        temperatureService.saveTemperature(city, temperature);
        System.out.println("Temperature of " + city + " is " + temperature);
    }

}
