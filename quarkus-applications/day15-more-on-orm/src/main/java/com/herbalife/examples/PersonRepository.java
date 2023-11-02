package com.herbalife.examples;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Integer> {


    @Inject
    EntityManager entityManager;

    public List<Person> getAll() {
        String query = "select * from persons"; //NOT RECOMMENDED
        List<Person> persons = entityManager.createNativeQuery(query, Person.class).getResultList();
        return persons;
    }

    public List<String> getFirstNames() {
        String query = "select p.firstName from Person p";
        List<String> firstNames = find(query).project(String.class).list();
        return firstNames;
    }

    public List<Person> getAllWithAgeGreaterThan(int age) {
        //Approach 1
//        String query = "select p from Person p where p.age > ?1";
//        List<Person> persons = find(query, age).list();
//        return persons;

        //Approach 2
        //return find("age > ?1", age).list();

        //Approach 3
        String query = "from Person p where p.age > :ageParam";
        Map<String, Object> params = Map.of("ageParam", age);
        return find(query, params).list();

    }

    public List<Person> getAllWithAgeBetween(int start, int end) {
        //Approach 1
//        String query = "from Person p where p.age between :startParam and :endParam";
//        Map<String, Object> params = Map.of("startParam", start, "endParam", end);
//        return find(query, params).list();

        String query = "from Person p where p.age between ?1 and ?2";
        return find(query, start, end).list();

    }

    public List<Person> getAllNames() {
        String query = "select p.firstName, p.lastName from Person p";
        List<Person> persons = find(query).list();
        return persons;
    }
}
