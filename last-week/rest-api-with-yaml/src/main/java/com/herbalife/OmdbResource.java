package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/omdb")
public class OmdbResource {

    @ConfigProperty(name = "omdb.api-key")
    private String apiKey;
    @ConfigProperty(name = "omdb.base-url")
    private String baseUrl;
    @ConfigProperty(name = "omdb.license-expiry")
    private String licenseExpiry;

    @GET
    public String getOmdbPath() {
        return baseUrl + "?apiKey=" + apiKey;
    }

    @GET
    @Path("/license-expiry")
    public String getLicenseExpiry() {
        return licenseExpiry;
    }
}
