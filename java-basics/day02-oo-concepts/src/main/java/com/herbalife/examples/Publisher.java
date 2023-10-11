package com.herbalife.examples;

public class Publisher {
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                '}';
    }
}
