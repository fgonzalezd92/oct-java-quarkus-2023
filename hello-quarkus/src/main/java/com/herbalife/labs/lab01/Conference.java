package com.herbalife.labs.lab01;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Conference {
    @Inject
    SessionPlanner sessionPlanner;

    public int getLengthOf(int duration) {
        return sessionPlanner.topics().get(duration).size();
    }
}
