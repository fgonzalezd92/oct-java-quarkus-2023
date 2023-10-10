package com.herbalife.monday;

import java.util.Scanner;

public class Lab01 {

    public static final String AIM_LOWER = "Aim Lower";
    public static final String AIM_HIGHER = "Aim Higher";

    public static void main(String[] args) {
        int target = (int) (Math.random() * 100);
        int attempts = 0;
        String message = "";
        boolean gameOver = false;
        System.out.println("Welcome to the guessing game. Enter a number between 1 and 100");
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            attempts++;
            int guess = scanner.nextInt();
            if (guess > target) {
                message = AIM_LOWER;
            } else if (guess < target) {
                message = AIM_HIGHER;
            } else {
                //message = "You've got it in " + attempts + " attempts";
                message = "You've got it in %s attempts".formatted(attempts);
                gameOver = true;
            }
            System.out.println(message);
        }
    }
}
