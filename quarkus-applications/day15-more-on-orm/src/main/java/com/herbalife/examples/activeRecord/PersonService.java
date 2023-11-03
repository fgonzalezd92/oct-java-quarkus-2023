package com.herbalife.examples.activeRecord;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonService {

    @Transactional
    public void createPerson(String firstName, String lastName, int age) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        person.persist(); //NO repository needed
    }

    @Transactional
    public void removePerson(int id) {
        Person person = Person.findById(id);
        person.delete(); //NO repository needed
    }

    public List<Person> getAllPersons() {
        return Person.listAll(); //NO repository needed
    }

    public List<String> getAllFirstNames() {
        return Person
                .find("select firstName from Person")
                .project(String.class)
                .list(); //NO repository needed
    }

}
