package com.herbalife.examples.jdbc;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {
    public String hello() {
        return "Hello World!";
    }
}
