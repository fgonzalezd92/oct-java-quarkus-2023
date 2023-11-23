package com.herbalife.examples;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class Engine {
    @Inject
    private Mechanism mechanism;

    public Mechanism getMechanism() {
        return mechanism;
    }
}
