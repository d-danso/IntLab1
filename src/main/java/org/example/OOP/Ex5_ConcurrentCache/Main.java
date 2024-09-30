package org.example.OOP.Ex5_ConcurrentCache;


public class Main {
    public static void main(String[] args) {
        Cache<String, String> cache = new Cache<>();
        cache.put("1", "One");
        cache.put("2", "Two");

        System.out.println("Value for key 1: " + cache.get("1"));
        System.out.println("Cache contains key 2: " + cache.containsKey("2"));
    }
}
