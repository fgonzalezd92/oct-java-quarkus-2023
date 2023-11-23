package com.herbalife.resource;

import com.herbalife.model.Person;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/greetings")
@Tag(name = "Greetings", description = "Greetings API")
public class GreetingsResource {

    @Operation(summary = "Say hello to person")
    @APIResponse(description = "Hello person", name = "Hello", responseCode = "200")
    @POST
    @Path("/hello")
    public String helloPerson(Person person) {
        return "Hello " + person.getFirstName() + " " + person.getLastName();
    }

    @Operation(summary = "Say hello to someone")
    @APIResponse(description = "Hello message", name = "Hello", responseCode = "200")
    @GET
    @Path("/hello/{name}")
    public String hello(String name) {
        return "Hello " + name;
    }

    @Operation(summary = "Say bye to someone")
    @APIResponse(description = "Bye message", name = "Bye", responseCode = "200")
    @GET
    @Path("/bye/{name}")
    public String bye(String name) {
        return "Bye " + name;
    }

}
