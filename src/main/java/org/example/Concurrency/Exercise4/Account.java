package org.example.Concurrency.Exercise4;

// Account.java
public class Account {
    private int balance = 1000;

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account from, Account to, int amount) {
        synchronized (from) {
            synchronized (to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }
}

