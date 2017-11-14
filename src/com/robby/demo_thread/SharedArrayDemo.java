package com.robby.demo_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Robby
 */
public class SharedArrayDemo {

    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(6);

        ArrayWriter writer1 = new ArrayWriter(simpleArray, 1);
        ArrayWriter writer2 = new ArrayWriter(simpleArray, 11);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(writer1);
        executorService.execute(writer2);
        executorService.shutdown();

        try {
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
            if (tasksEnded) {
                System.out.printf("%nContents of SimpleArray:%n");
                System.out.println(simpleArray); // print contents
            } else {
                System.out.println("Timed out while waiting for tasks to finish.");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
