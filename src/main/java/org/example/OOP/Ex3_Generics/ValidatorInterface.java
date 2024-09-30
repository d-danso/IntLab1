package org.example.OOP.Ex3_Generics;

//@FunctionalInterface
public interface ValidatorInterface<T> {
    boolean validate(T t);
}
