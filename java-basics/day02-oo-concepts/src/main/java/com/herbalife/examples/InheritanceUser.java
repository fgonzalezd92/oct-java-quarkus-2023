package com.herbalife.examples;

public class InheritanceUser {
    public static void main(String[] args) {
        Manager m1 = new Manager("Sam", 5);
        m1.work(12);

        //Employee e1 = new Employee("Ram");
        Employee e1 = new Manager("Ram", 10);
        e1.work(12);
    }
}
