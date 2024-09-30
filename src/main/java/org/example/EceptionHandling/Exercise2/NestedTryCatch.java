package org.example.EceptionHandling.Exercise2;


public class NestedTryCatch {

    public static void main(String[] args) {
        try {
            int[] array = {1, 2, 3};
            try {
                int result = array[1] / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
    }
}
