package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CarService {
    @Inject
    CarRepository carRepository;

    @Transactional
    public void addCar(String model, Person person) {
        Car car = new Car();
        car.setModel(model);
        car.setOwner(person);
        carRepository.persist(car);
    }

    public List<Car> getAllCars() {
        return carRepository.listAll();
    }
}
