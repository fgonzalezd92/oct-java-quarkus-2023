package com.herbalife.examples.jpa;

import com.herbalife.examples.jdbc.PersonInputDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/people")
public class PeopleResource {

    @Inject
    PersonService personService;

    @PATCH
    @Path("/id/{id}/age/{age}")
    public String updateAge(@PathParam("id") int id, @PathParam("age") int age) {
        personService.updateAge(id, age);
        return "Age updated";
    }

    @GET
    public List<Person> getPeople() {
        return personService.getAllPersons();
    }
    @POST
    public String createPerson(PersonInputDto personInputDto) {
        personService.createPerson(personInputDto.firstName(), personInputDto.lastName(), personInputDto.age());
        return "Person created";
    }

}
