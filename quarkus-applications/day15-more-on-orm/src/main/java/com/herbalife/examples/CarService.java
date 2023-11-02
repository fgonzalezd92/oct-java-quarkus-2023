package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CarService {
    @Inject
    CarRepository carRepository;
}
