package org.example.OOP.Ex3_Generics;

public class Main {
    public static void main(String[] args) {
        boolean isStringValid = Validator.validate("Hello", (str) -> !str.isEmpty());
        boolean isNumberValid = Validator.validate(10, (num) -> num > 0);

        System.out.println("Is String Valid: " + isStringValid);
        System.out.println("Is Number Valid: " + isNumberValid);
    }
}
