package com.robby.demo_thread;

import java.util.Random;

/**
 *
 * @author Robby
 */
public class PrintTaskThread extends Thread {

    private final int sleepTime;
    private final String taskName;
    private final static Random generator = new Random();
    private int limit;
    private final ThreadCallBack threadCallBack;

    public PrintTaskThread(String taskName, int limit) {
        this.taskName = taskName;
        this.limit = limit;
        threadCallBack = new ThreadCallBack() {
            @Override
            public void onCompleted() {
                System.out.printf(taskName + " is completed");
            }
        };
        sleepTime = generator.nextInt(5000);
    }

    @Override
    public void run() {
        System.out.println(taskName + " created and running");
        System.out.println("Print using for loop");
        int limit = generator.nextInt(20) + 1;
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
        threadCallBack.onCompleted();
    }

}
