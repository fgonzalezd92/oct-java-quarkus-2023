package com.herbalife.examples.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    @Transactional //you need to add this whenever you are performing an insert/update/delete operation
    public void createPerson(String firstName, String lastName, int age) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        personRepository.persist(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    @Transactional
    public void updateAge(int id, int age) {
        Optional<Person> optionalPerson = personRepository.findByIdOptional(id);
        if(optionalPerson.isEmpty()) {
            throw new RuntimeException("Person with id " + id + " not found");
        }
        Person person = optionalPerson.get();
        person.setAge(age);
        personRepository.persist(person);
    }
}
