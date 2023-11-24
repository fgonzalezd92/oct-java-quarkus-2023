package com.herbalife;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

@Path("/basic")
public class BasicAuthResource {

    @GET
    @Path("/sample")
    public String sample() {
        return "sample";
    }

    @GET
    @Path("/forbidden")
    @DenyAll
    public String forbidden() {
        return "You should not see this!";
    }

    @GET
    @Path("/login")
    @PermitAll
    public String login(@Context SecurityContext ctx) {
        return "Please login!";
    }

    @GET
    @Path("/home")
    @RolesAllowed({"users", "admin"})
    public String home(@Context SecurityContext ctx) {
        return "Welcome home " + ctx.getUserPrincipal().getName() + " in role " + ctx.isUserInRole("users");
    }

}
