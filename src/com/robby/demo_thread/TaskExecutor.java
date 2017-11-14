package com.robby.demo_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Robby
 */
public class TaskExecutor {

    public static void main(String[] args) {
        System.out.println("Creating Task");
        PrintTaskRunnable taskRunnable1 = new PrintTaskRunnable("Runnable Task 1", 10);
        PrintTaskRunnable taskRunnable2 = new PrintTaskRunnable("Runnable Task 2", 10);
        PrintTaskRunnable taskRunnable3 = new PrintTaskRunnable("Runnable Task 3", 10);

        PrintTaskThread taskThread1 = new PrintTaskThread("Thread Task 1", 8);
        PrintTaskThread taskThread2 = new PrintTaskThread("Thread Task 2", 8);
        PrintTaskThread taskThread3 = new PrintTaskThread("Thread Task 3", 8);

        System.out.println("Starting Executor");
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.out.println("Start runnable");
        executorService.execute(taskRunnable1);
        executorService.execute(taskRunnable3);
        executorService.execute(taskRunnable3);

        System.out.println("Start thread");
        executorService.execute(taskThread1);
        executorService.execute(taskThread2);
        executorService.execute(taskThread3);

        executorService.shutdown();
        System.out.println("Task started, main ends");
    }
}
