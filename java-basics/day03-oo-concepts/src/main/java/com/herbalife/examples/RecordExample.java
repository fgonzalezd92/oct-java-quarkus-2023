package com.herbalife.examples;

public class RecordExample {
    public static void main(String[] args) {
        PersonInput personInput = new PersonInput(101, "Sam");
        int id = personInput.id();
        String name = personInput.name();
        String message = "Id: " + id + ", name: " + name;
        String latestMessage = "Id: %s, name: %s".formatted(id, name); //printf style in C


    }
}

record PersonInput(int id, String name){}
