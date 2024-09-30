package org.example.Concurrency.Exercise4;

// Main.java
public class Main {
    public static void main(String[] args) {
        Account account1 = new Account();
        Account account2 = new Account();

        Thread thread1 = new Thread(() -> Account.transfer(account1, account2, 100));
        Thread thread2 = new Thread(() -> Account.transfer(account2, account1, 50));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}
