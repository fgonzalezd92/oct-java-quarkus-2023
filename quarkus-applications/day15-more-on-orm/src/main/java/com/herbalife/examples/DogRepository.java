package com.herbalife.examples;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DogRepository implements PanacheRepositoryBase<Dog, Integer> {
}
