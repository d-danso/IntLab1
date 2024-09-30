package org.example.OOP.Ex4_GenericsStack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        System.out.println("Popped: " + integerStack.pop());
        System.out.println("Stack Size: " + integerStack.size());
    }
}
