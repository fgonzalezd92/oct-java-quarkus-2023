package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient(configKey = "my-nodejs-api")
public interface MyNodeJsAPI {

    @GET
    @Path("/hello/{name}")
    String hello(String name);

    @POST
    @Path("/bye/{name}")
    String bye(String name);
    //NodeApiResponse bye(String name);
}
