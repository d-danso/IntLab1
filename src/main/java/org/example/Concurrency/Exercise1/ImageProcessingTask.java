package org.example.Concurrency.Exercise1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageProcessingTask implements Runnable {
    private String imageName;

    public ImageProcessingTask(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void run() {
        System.out.println("Processing image: " + imageName + " by " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            ImageProcessingTask task = new ImageProcessingTask("Image" + i);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}

