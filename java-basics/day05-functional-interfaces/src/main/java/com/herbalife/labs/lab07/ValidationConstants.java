package com.herbalife.labs.lab07;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface ValidationConstants {
    Predicate<String> isNotNull = value -> value != null;
    Predicate<String> isNotBlank = value -> !value.isBlank();
    Predicate<String> isNotEmpty = value -> !value.isEmpty();
    BiFunction<Integer, Integer, Predicate<String>> lengthValidator = (min, max) -> value -> value.length() >= min && value.length() <= max;
    Predicate<String> hasUpperCase = value -> value.matches(".*[A-Z].*");
    Predicate<String> hasDigit = value -> value.matches(".*\\d+.*");

//    Predicate<String> isUsernameLengthValid = value -> value.length() >= 6 && value.length() <= 12;
//    Predicate<String> isPasswordLengthValid = value -> value.length() >= 8 && value.length() <= 14;

}
