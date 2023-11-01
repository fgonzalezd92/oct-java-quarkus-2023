package com.herbalife.examples.jpa;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

//similar to defining a DAO class
@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Integer> {
}
