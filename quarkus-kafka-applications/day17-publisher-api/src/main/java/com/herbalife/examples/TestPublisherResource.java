package com.herbalife.examples;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/test")
public class TestPublisherResource {

    @Inject
    @Channel("my-test-channel")
    Emitter<String> emitter;

    @Inject
    @Channel("hl-channel")
    Emitter<String> hlEmitter;

    @GET
    @Path("/hl/{message}")
    public String publishHLMessage(@PathParam("message") String message) {
        hlEmitter.send(message);
        return "Message published: " + message;
    }

    @GET
    @Path("/{message}")
    public String publishMessage(@PathParam("message") String message) {
        emitter.send(message);
        return "Message published: " + message;
    }
}
