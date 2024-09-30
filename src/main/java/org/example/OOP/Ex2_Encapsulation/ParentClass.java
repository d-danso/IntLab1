package org.example.OOP.Ex2_Encapsulation;

public class ParentClass {
    private String outerField = "Outer Field";

    class ChildClass {
        void display() {
            System.out.println("Outer Field is: " + outerField);
        }
    }
}


