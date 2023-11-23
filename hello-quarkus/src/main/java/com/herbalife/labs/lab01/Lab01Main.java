package com.herbalife.labs.lab01;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Lab01Main implements QuarkusApplication {

    @Inject
    Conference conference;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Number of 60 mins topics: " + conference.getLengthOf(60));
        System.out.println("Number of 90 mins topics: " + conference.getLengthOf(90));
        System.out.println("Number of 45 mins topics: " + conference.getLengthOf(45));
        return 0;
    }
}
