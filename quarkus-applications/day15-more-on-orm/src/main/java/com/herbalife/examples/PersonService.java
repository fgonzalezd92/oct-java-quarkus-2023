package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    public List<String> getFirstNames() {
        List<String> firstNames = personRepository.getFirstNames();
        return firstNames;
    }

    public List<Person> getPersonsWithAgeGreaterThan(int age) {
        List<Person> persons = personRepository.getAllWithAgeGreaterThan(age);
        return persons;
    }

    public List<Person> getNames() {
        List<Person> persons = personRepository.getAllNames();
        return persons;
    }

    @Transactional
    public Person addPerson(String firstName, String lastName, int age) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        personRepository.persist(person);
        return person;
    }

    public List<Person> getPersonsWithAtleastDogs(int count) {
        return personRepository.getPersonsWithAtleastDogs(count);
    }
}
