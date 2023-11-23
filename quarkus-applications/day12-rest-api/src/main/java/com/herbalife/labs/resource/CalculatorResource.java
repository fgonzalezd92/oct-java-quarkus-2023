package com.herbalife.labs.resource;

import com.herbalife.labs.service.CalculatorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/calc")
public class CalculatorResource {
    @Inject
    private CalculatorService calculatorService;

    @GET
    @Path("/sum/{a}/{b}")
    public int sum(@PathParam("a") int a, @PathParam("b") int b) {
        return calculatorService.sum(a, b);
    }

    @PUT
    @Path("/square/{a}")
    public int square(@PathParam("a") int a) {
        return calculatorService.square(a);
    }

    @POST
    @Path("/product")
    public int product(@QueryParam("a") int a, @QueryParam("b") int b) {
        return calculatorService.product(a, b);
    }

    @GET
    @Path("/operations")
    public List<String> operations() {
        return calculatorService.getOperations();
    }
}
