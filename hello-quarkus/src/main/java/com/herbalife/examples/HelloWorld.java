package com.herbalife.examples;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain // This annotation tells Quarkus that this is the main class
public class HelloWorld implements QuarkusApplication {


    @Inject
    Car car; // = new Car();

    @Inject
    Car anotherCar;

    @Override
    public int run(String... args) throws Exception {
//        System.out.println("Hello Quarkus!");
//        System.out.println("Hello Quarkus!");
        //Car car = new Car();
        System.out.println(car);
        System.out.println(anotherCar);
        System.out.println(car == anotherCar);

        System.out.println(car.getOwner());
        System.out.println(car.getEngine());
        System.out.println(car.getEngine().getMechanism());


        return 0;
    }
}
