package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/sample")
public class SampleResource {

    @GET
    @Path("/division2/{a}/{b}")
    public int divide2(@PathParam("a") int a, @PathParam("b") int b) {
        if(b == 0)
            throw new InvalidNumberException("Cannot divide by zero");
        return a / b;
    }

    @GET
    @Path("/division/{a}/{b}")
    public int divide(@PathParam("a") int a, @PathParam("b") int b) {
        return a / b;
    }
}
