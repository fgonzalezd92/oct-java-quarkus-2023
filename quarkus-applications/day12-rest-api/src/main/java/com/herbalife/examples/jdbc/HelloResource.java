package com.herbalife.examples.jdbc;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class HelloResource {

    @ConfigProperty(name = "welcome.message")
    private String welcomeMessage;

    @Inject
    HelloService helloService;

    @GET
    public String hello() {
        return helloService.hello();
    }

    @GET
    @Path("/{name}")
    public String hi(@PathParam("name") String name) {
        return "Hi " + name + "!";
    }

    @POST
    @Path("/register")
    public String registerForTraining(@QueryParam("email") String email) {
        return "Registered " + email + " for training!";
    }

    @DELETE
    @Path("/deregister")
    public String deregisterForTraining(@FormParam("email") String email) {
        return "Deregistered " + email + " for training!";
    }

    @GET
    @Path("/training")
    public String getTraining(@HeaderParam("version")int version) {
        return "Training version " + version;
    }


}
