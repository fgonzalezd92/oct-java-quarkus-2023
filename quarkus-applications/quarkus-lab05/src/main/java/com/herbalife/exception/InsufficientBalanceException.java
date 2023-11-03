package com.herbalife.exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super("Insufficient balance: " + message);
    }
}
