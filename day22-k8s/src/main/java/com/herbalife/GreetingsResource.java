package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greetings")
public class GreetingsResource {

    @ConfigProperty(name = "welcome")
    private String welcome;

    @ConfigProperty(name = "goodbye")
    private String goodbye;

    @ConfigProperty(name = "datasource.url")
    private String datasourceUrl;

    @ConfigProperty(name = "datasource.username")
    private String datasourceUsername;

    @ConfigProperty(name = "datasource.password")
    private String datasourcePassword;

    @GET
    @Path("/hello")
    public String hello() {
        return welcome;
    }

    @GET
    @Path("/bye")
    public String bye() {
        return goodbye;
    }

    @GET
    @Path("/datasource")
    public String datasource() {
        return "URL: " + datasourceUrl + " - Username: " + datasourceUsername + " - Password: " + datasourcePassword;
    }


}
