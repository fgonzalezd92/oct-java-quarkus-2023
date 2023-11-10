package com.herbalife.service;

import com.herbalife.entity.Temperature;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.List;

@ApplicationScoped
public class TemperatureService {

    @Inject
    @Channel("weather-channel")
    Emitter<String> weatherEmitter;

    public void postCityToTopic(String city) {
        weatherEmitter.send(city);
    }

    public List<Temperature> getAllObservedTemperatures(String city) {
        return Temperature.list("city", city);
    }
}
