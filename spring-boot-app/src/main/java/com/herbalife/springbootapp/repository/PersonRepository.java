package com.herbalife.springbootapp.repository;

import com.herbalife.springbootapp.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
