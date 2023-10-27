package com.herbalife.examples;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

//@QuarkusMain // This annotation tells Quarkus that this is the main class
public class HelloWorld implements QuarkusApplication {


    @Inject
    Company company;

    @Inject
    Car car; // = new Car();

    @Inject
    Car anotherCar;

    @Inject
    DatabaseSettings databaseSettings;

    @Inject
    MyDatabaseSettings myDatabaseSettings;

    @Inject
    Door door;

    @Override
    public int run(String... args) throws Exception {

        System.out.println(door.getAlarm());


//        System.out.println(myDatabaseSettings.user());
//        System.out.println(myDatabaseSettings.password());
//        System.out.println(myDatabaseSettings.server());
//        System.out.println(myDatabaseSettings.port());
//        System.out.println(myDatabaseSettings.database());

//        System.out.println(databaseSettings);
//        System.out.println(company.getName());
//        System.out.println(company.getCountry());
//        company.getLocations().forEach(System.out::println);


//        System.out.println("Hello Quarkus!");
//        System.out.println("Hello Quarkus!");
        //Car car = new Car();
//        System.out.println(car);
//        System.out.println(anotherCar);
//        System.out.println(car == anotherCar);
//
//        System.out.println(car.getOwner());
//        System.out.println(car.getEngine());
//        System.out.println(car.getEngine().getMechanism());


        return 0;
    }
}
