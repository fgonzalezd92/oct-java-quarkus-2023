package com.herbalife.service;

import com.herbalife.api.OmdbApi;
import com.herbalife.api.OmdbApiResponse;
import com.herbalife.document.Movie;
import com.herbalife.dto.MovieDto;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;

import java.util.Optional;

@ApplicationScoped
public class MovieService {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(MovieService.class);

    @RestClient
    OmdbApi omdbApi;

    public void addMovieDetailsFromOmdb(String title) {
        OmdbApiResponse omdbApiResponse = omdbApi.getMovieDetails(title);
        Movie movie = new Movie();
        movie.setTitle(omdbApiResponse.getTitle());
        movie.setLanguage(omdbApiResponse.getLanguage());
        movie.setActors(omdbApiResponse.getActors());
        movie.setYear(omdbApiResponse.getYear());
        movie.persist();
        logger.info("Movie {} details added to db", title);
    }

    public MovieDto getMovieDetailsFromDb(String title) {
        Optional<Movie> optionalMovie = Movie.find("title", title).firstResultOptional();
        if (optionalMovie.isEmpty()) {
            logger.error("Movie {} not found", title);
            throw new RuntimeException("Movie not found");
        } else {
            Movie movie = optionalMovie.get();
            return new MovieDto(movie.getTitle(), movie.getLanguage(), movie.getActors(), movie.getYear());
        }
    }
}
