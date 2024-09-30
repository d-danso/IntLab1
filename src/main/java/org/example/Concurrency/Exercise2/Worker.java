package org.example.Concurrency.Exercise2;

// Worker.java
import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch, String name) {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " finished work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker1 = new Worker(1000, latch, "Worker-1");
        Worker worker2 = new Worker(2000, latch, "Worker-2");
        Worker worker3 = new Worker(3000, latch, "Worker-3");

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All workers finished. Proceeding with main thread.");
    }
}
