package org.example.OOP.Ex2_Encapsulation;


public class Main {
    public static void main(String[] args) {
        ParentClass outerClass = new ParentClass();
        ParentClass.ChildClass innerClass = outerClass.new ChildClass();
        innerClass.display();
    }
}

