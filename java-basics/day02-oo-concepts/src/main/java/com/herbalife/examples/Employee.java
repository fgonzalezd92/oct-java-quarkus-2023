package com.herbalife.examples;

public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work(int hours) {
        System.out.println("Employee %s works %s hours".formatted(this.name, hours));
    }

    private void fileTax() {

    }
}
