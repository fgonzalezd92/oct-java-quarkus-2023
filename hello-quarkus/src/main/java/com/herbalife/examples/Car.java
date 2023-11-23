package com.herbalife.examples;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton //specifies the scope of the bean
public class Car {
    @Inject
    private Engine engine; // = new Engine();

    private Owner owner;

    @Inject //Not needed
    public Car(Owner owner) {
        this.owner = owner;
    }

    public Engine getEngine() {
        return engine;
    }

    public Owner getOwner() {
        return owner;
    }
}
