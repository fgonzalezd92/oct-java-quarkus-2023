package com.herbalife.labs.lab03;

public record Transaction(long accountNumber,
                          double amount,
                          AccountOperationType type,
                          String time) {

}
