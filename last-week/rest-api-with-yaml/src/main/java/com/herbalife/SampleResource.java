package com.herbalife;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/sample")
public class SampleResource {
    @Inject
    SampleService sampleService;
    @GET
    @Path("/hello/{name}")
    public String hello(String name) {
        Log.warnv("Hello warn {0} from SampleResource", name);
        Log.debugv("Hello debug {0} from SampleResource", name);
        return sampleService.sayHello(name);
    }
}

@ApplicationScoped
class SampleService {
    public String sayHello(String name) {
        Log.infov("Hello {0} from SampleService", name);
        return "Hello from SampleService";
    }
}
