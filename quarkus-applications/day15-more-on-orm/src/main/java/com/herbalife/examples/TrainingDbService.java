package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TrainingDbService {

    @Inject
    PersonRepository personRepository;

    @Inject
    CarRepository carRepository;

    @Inject
    DogRepository dogRepository;

    @Transactional
    public void addPersonWithCarsAndDogs(PersonDto personDto) {
        List<Dog> dogs = new ArrayList<>();
        for (String dogName : personDto.dogs()) {
            Dog dog = new Dog();
            dog.setName(dogName);
            dogRepository.persist(dog);
            dogs.add(dog);
        }
        Person person = new Person();
        person.setFirstName(personDto.firstName());
        person.setLastName(personDto.lastName());
        person.setAge(personDto.age());
        person.setDogs(dogs);
        personRepository.persist(person);

        for (String carModel : personDto.cars()) {
            Car car = new Car();
            car.setModel(carModel);
            car.setOwner(person);
            carRepository.persist(car);
        }


    }
}
