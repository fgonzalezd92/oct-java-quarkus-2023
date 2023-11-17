package com.herbalife;

import com.herbalife.service.MovieService;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MovieCacheCleaner {
    @Inject
    MovieService movieService;

    @Scheduled(every = "1m")
    public void clearMovieCache() {
        movieService.clearAllCache();
    }
}
