package org.example.DSA.Exercise2;

import java.util.PriorityQueue;

class Task implements Comparable<Task> {
    private int priority;
    private String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task o) {
        return this.priority - o.priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + '}';
    }

    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        taskQueue.add(new Task(3, "Write report"));
        taskQueue.add(new Task(1, "Attend meeting"));
        taskQueue.add(new Task(2, "Check email"));

        while (!taskQueue.isEmpty()) {
            System.out.println("Processing " + taskQueue.poll());
        }
    }
}

