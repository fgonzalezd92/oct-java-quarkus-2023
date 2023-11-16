package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/greetings")
public class GreetingsResource {

    @RestClient
    MyNodeJsAPI myNodeJsAPI;

    @GET
    @Path("/hello/{name}")
    public String hello(@PathParam("name") String name) throws IOException, InterruptedException {

        return "Using RESTClient: " + myNodeJsAPI.hello(name);


        //talk to the node js service
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:3000/hello/" + name))
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        return "Response from Node JS: " + response.body();
    }

    @GET
    @Path("/bye/{name}")
    public String bye(@PathParam("name") String name) {
        //talk to the node js service
        return "Using RESTClient: " + myNodeJsAPI.bye(name);
    }
}
