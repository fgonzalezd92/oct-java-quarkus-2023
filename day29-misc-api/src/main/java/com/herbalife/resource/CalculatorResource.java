package com.herbalife.resource;

import com.herbalife.service.CalculatorService;
import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/calc")
public class CalculatorResource {

    @Inject
    CalculatorService calculatorService;
    @GET
    @Path("/sum/{a}/{b}")
    public int sum(int a, int b) {
        Log.infov("Summing {0} + {1}", a, b);
        return calculatorService.sum(a, b);
    }

    @GET
    @Path("/square/{a}")
    public int square(int a) {
        Log.infov("Squaring {0}", a);
        return calculatorService.square(a);
    }

}
