package com.herbalife.resource;

import com.herbalife.document.Movie;
import com.herbalife.dto.MovieDto;
import com.herbalife.service.MovieService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/movies")
public class MovieResource {
    @Inject
    MovieService movieService;

    @POST
    public Response addMovie(@FormParam("title") String title) {
        movieService.addMovieDetailsFromOmdb(title);
        return Response.ok().build();
    }

    @GET
    public MovieDto getMovie(@FormParam("title") String title) {
        return movieService.getMovieDetailsFromDb(title);
    }
}
