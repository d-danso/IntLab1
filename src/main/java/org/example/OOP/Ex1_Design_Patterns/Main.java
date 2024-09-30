package org.example.OOP.Ex1_Design_Patterns;

// Main.java
public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.createNotification("EMAIL");
        notification.notifyUser();

        notification = factory.createNotification("SMS");
        notification.notifyUser();
    }
}
