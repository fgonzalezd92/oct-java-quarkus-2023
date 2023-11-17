package com.herbalife.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient(configKey = "omdb-api")
public interface OmdbApi {

    @GET
    OmdbApiResponse getMovieDetails(@QueryParam("t") String title);

}
