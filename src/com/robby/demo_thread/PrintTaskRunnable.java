package com.robby.demo_thread;

import java.util.Random;

/**
 *
 * @author Robby
 */
public class PrintTaskRunnable implements Runnable {

    private final int sleepTime;
    private final String taskName;
    private final static Random generator = new Random();
    private int limit;

    public PrintTaskRunnable(String taskName, int limit) {
        this.taskName = taskName;
        this.limit = limit;
        sleepTime = generator.nextInt(5000);
    }

    @Override
    public void run() {
        System.out.println(taskName + " created and running");
        System.out.println("Print using for loop");
        for (int i = 0; i < limit; i++) {
            System.out.printf("%s %d%n", taskName, i);
        }
        try {
            System.out.printf("%s going to sleep for %d milliseconds.\n",
                    taskName, sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.printf("$s %s\n", taskName,
                    "terminated prematurely due to interruption");
        }
        System.out.printf("%s done sleeping\n", taskName);
    }

}
