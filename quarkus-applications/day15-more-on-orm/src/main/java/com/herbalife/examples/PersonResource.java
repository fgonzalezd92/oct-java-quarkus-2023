package com.herbalife.examples;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonService personService;

    @Inject
    CarService carService;

    @Inject
    TrainingDbService trainingDbService;


    @GET
    @Path("/dogs/{count}")
    public List<Person> getPersonsWithAtleastDogs(@QueryParam("count") int count) {
        return personService.getPersonsWithAtleastDogs(count);
    }

    @POST
    @Path("/carsanddogs")
    public void addPersonWithCarsAndDogs(PersonDto personDto) {
        trainingDbService.addPersonWithCarsAndDogs(personDto);
    }

    @GET
    @Path("/cars")
    public void getAllCars() {
        List<Car> cars = carService.getAllCars();
        System.out.println("****** Printing car models ******");
        cars.forEach(car -> System.out.println(car.getId() + ", " + car.getModel()));
        System.out.println("****** Printing car owner details ******");
        cars.forEach(car -> System.out.println(car.getOwner().getId() + ", " + car.getOwner().getFirstName() + ", " + car.getOwner().getLastName()));
    }

    @POST
    public void addPersonWithCars(PersonDto personDto) {
        Person person  = personService.addPerson(personDto.firstName(), personDto.lastName(), personDto.age());
        personDto
                .cars()
                .forEach(model -> carService.addCar(model, person));
    }

    @GET
    @Path("/names")
    public List<Person> getAllNames() {
        return personService.getNames();
    }

    @GET
    @Path("/firstnames")
    public List<String> getAllFirstNames() {
        return personService.getFirstNames();
    }

    @GET
    @Path("/all/agegt")
    public List<Person> getPersonsWithAgeGreaterThan(@QueryParam("age") int age) {
        return personService.getPersonsWithAgeGreaterThan(age);
    }
}
