package com.herbalife.examples;

//Java Beans or POJO
public class Car {
    private String model;
    private int yearOfMake;

    //getter, setter methods are commonly referred to as properties in Java
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public void drive(int speed) {
        System.out.println("Driving %s at a speed of %s mph".formatted(this.model, speed));
    }
}
