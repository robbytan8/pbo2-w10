package com.robby.demo_thread;

/**
 *
 * @author Robby
 */
public class ThreadCreator {

    public static void main(String[] args) {
        System.out.println("Creating threads");
        Thread runnableThread1 = new Thread(new PrintTaskRunnable("Runnable Task 1", 10));
        Thread runnableThread2 = new Thread(new PrintTaskRunnable("Runnable Task 2", 10));
        Thread runnableThread3 = new Thread(new PrintTaskRunnable("Runnable Task 3", 10));

        System.out.println("Runnable creating. Starting Task");
        runnableThread1.start();
        runnableThread2.start();
        runnableThread3.start();

        System.out.println("Thread creating. Starting Task");
        new PrintTaskThread("Thread Task 1", 8).start();
        new PrintTaskThread("Thread Task 2", 8).start();
        new PrintTaskThread("Thread Task 3", 8).start();

        System.out.println("Task started, main ends");
    }
}
