package org.example.EceptionHandling.Exercise1;

import java.io.FileNotFoundException;

public class ExceptionHandling {


    public void readFile() throws FileNotFoundException {
        throw new FileNotFoundException("File not found");
    }


    public void divideByZero() {
        throw new ArithmeticException("Cannot divide by zero");
    }

    public static void main(String[] args) {
        ExceptionHandling handler = new ExceptionHandling();


        try {
            handler.readFile();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


        try {
            handler.divideByZero();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

