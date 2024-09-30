package org.example.OOP.Ex1_Design_Patterns;

// EmailNotification.java
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}
