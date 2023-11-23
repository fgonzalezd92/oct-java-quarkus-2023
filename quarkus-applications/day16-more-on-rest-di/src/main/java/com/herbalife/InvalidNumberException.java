package com.herbalife;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException(String message) {
        super("Invalid number error: " + message);
    }
}
