package org.example.Concurrency.Exercise3;

// Worker.java
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker extends Thread {
    private int delay;
    private CyclicBarrier barrier;

    public Worker(int delay, CyclicBarrier barrier, String name) {
        super(name);
        this.delay = delay;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        Worker worker1 = new Worker(1000, barrier, "Worker-1");
        Worker worker2 = new Worker(2000, barrier, "Worker-2");
        Worker worker3 = new Worker(3000, barrier, "Worker-3");

        worker1.start();
        worker2.start();
        worker3.start();
    }
}
