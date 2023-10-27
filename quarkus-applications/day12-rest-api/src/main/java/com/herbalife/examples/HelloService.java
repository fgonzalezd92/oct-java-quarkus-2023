package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {
    public String hello() {
        return "Hello World!";
    }
}
