package com.herbalife.examples;

public class Rtti {
    public static void main(String[] args) {
        Animal animal = new Dog();
        if(animal instanceof Dog) { //Similar to is operator in C#
            Dog dog = (Dog) animal;
            System.out.println("Animal is a dog");
        }
    }
}
class Animal {

}
class Dog extends Animal {}
class Cat extends Animal {}
