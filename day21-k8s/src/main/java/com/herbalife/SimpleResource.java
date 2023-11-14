package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/simple")
public class SimpleResource {

    @GET
    public String now() {
        return "It's now " + new java.util.Date();
    }
}
