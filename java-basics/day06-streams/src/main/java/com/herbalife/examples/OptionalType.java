package com.herbalife.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalType {
    static Map<Integer, String> romanNumbers = new HashMap<>();
    public static void main(String[] args) {
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");

        String value = getRomanNumberOf(1);
        System.out.println(value + ": Length is " + value.length());

        value = getRomanNumberOf(2);
        System.out.println(value + ": Length is " + value.length());

        value = getRomanNumberOf(11);
        if(value != null) { //need to have this check, though it's not mandatory
            System.out.println(value + ": Length is " + value.length());
        }

        Optional<String> optValue = getRomanNumeralOf(12);
        if(optValue.isPresent()) {
            String val = optValue.get();
            System.out.println(val + ": Length is " + val.length());
        }
    }

    private static Optional<String> getRomanNumeralOf(int num) {
        Optional<String> result = Optional.empty();
        if(romanNumbers.containsKey(num)) {
            result = Optional.of(romanNumbers.get(num));
        }
        return result;
    }

    private static String getRomanNumberOf(int num) {
        if(romanNumbers.containsKey(num)) {
            return romanNumbers.get(num);
        }
        return null; //NOT A GOOD PRACTICE
    }


}
