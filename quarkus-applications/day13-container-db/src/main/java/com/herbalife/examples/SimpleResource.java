package com.herbalife.examples;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class SimpleResource {

    @ConfigProperty(name = "welcome.message")
    private String welcome;

    @ConfigProperty(name = "goodbye.message")
    private String goodbye;
    @GET
    @Path("/hello")
    public String hello() {
        return welcome;
    }
    @GET
    @Path("/goodbye")
    public String goodbye() {
        return goodbye;
    }
}
