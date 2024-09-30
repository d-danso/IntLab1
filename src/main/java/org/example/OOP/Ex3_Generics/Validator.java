package org.example.OOP.Ex3_Generics;

public class Validator {
    public static <T> boolean validate(T data, ValidatorInterface<T> validator) {

        return validator.validate(data);
    }
}

