package com.herbalife.labs.lab07;

import static com.herbalife.labs.lab07.ValidationConstants.*;

public class Lab07Main {
    public static void main(String[] args) {
        String username = "prabhu";
        String password = "Prabhu123";

        boolean usernameValid = isNotNull
                .and(isNotBlank)
                .and(isNotEmpty)
                .and(lengthValidator.apply(6, 12))
                .test(username);
        System.out.println(username + "? " + usernameValid);

        boolean passwordValid = isNotNull
                .and(isNotBlank)
                .and(isNotEmpty)
                .and(lengthValidator.apply(8, 14))
                .and(hasUpperCase)
                .and(hasDigit)
                .test(password);
        System.out.println(password + "? " + passwordValid);
    }
}
