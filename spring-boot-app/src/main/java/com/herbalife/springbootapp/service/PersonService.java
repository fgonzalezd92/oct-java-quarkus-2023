package com.herbalife.springbootapp.service;


import com.herbalife.springbootapp.entity.Person;
import com.herbalife.springbootapp.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @Transactional
    public Person savePerson(Person person) {
        return repository.save(person);
    }
}
