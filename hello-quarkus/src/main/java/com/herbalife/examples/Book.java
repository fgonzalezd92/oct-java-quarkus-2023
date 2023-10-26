package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Singleton;

//@Singleton
//@RequestScoped
//@SessionScoped
@ApplicationScoped //most commonly used scope; one instance per application; but slightly different from singleton
//@Dependent //one instance per injection
public class Book {
}
