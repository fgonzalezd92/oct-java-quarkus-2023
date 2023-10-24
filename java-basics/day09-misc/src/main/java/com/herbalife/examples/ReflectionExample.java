package com.herbalife.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //java.lang.Class is the entry point for all the reflection operations
        //Similar to System.Type in C#
        Class carCls = Class.forName("com.herbalife.examples.Car");//Similar to Type.GetType() in C#
        System.out.println(carCls.getName());
        Arrays
                .stream(carCls.getDeclaredFields())
                .forEach(field -> System.out.println(field.getName()));
        Arrays
                .stream(carCls.getDeclaredMethods())
                .forEach(method -> System.out.println(method.getName()));
        Arrays
                .stream(carCls.getDeclaredAnnotations())
                .forEach(annotation -> System.out.println(annotation.annotationType().getName()));

        Arrays
                .stream(carCls.getDeclaredConstructors())
                .forEach(constructor -> System.out.println(constructor.getName()));

        Constructor constructor = carCls.getConstructor(new Class[]{});
        Object car = constructor.newInstance(new Object[]{}); //Similar to Activator.CreateInstance() in C#
        System.out.println(car.getClass().getName());
        Method method = carCls.getMethod("drive", new Class[]{});
        method.invoke(car, new Object[]{});
    }
}

@Monday
class Car {
    private String make;
    private String model;
    private int year;

    public Car() {
        System.out.println("Car constructor called");
    }

    public void drive() {
        System.out.println("Driving");
    }
}
