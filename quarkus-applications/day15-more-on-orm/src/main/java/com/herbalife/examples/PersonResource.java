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

    @POST
    public void addPerson(PersonDto personDto) {
        Person person  = personService.addPerson(personDto.firstName(), personDto.lastName(), personDto.age());
        personDto
                .cars()
                .forEach(carModel -> carService.addCar(person, carModel));
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
