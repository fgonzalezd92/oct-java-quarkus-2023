package com.herbalife.resource;

import com.herbalife.entity.Temperature;
import com.herbalife.service.TemperatureService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/weather")
public class WeatherResource {

    @Inject
    private TemperatureService temperatureService;

    @POST
    @Path("/{city}")
    public void findTemperatureOf(@PathParam("city") String city) {
        temperatureService.postCityToTopic(city);
    }

    @GET
    @Path("/{city}")
    public List<Temperature> getAllObservedTemperatures(@PathParam("city") String city) {
        return temperatureService.getAllObservedTemperatures(city);
    }
}
