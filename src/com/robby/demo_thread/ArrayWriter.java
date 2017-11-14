package com.robby.demo_thread;

/**
 *
 * @author Robby
 */
public class ArrayWriter implements Runnable {

    private final SimpleArray simpleArray;
    private final int startValue;

    public ArrayWriter(SimpleArray simpleArray, int startValue) {
        this.simpleArray = simpleArray;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        for (int i = startValue; i < startValue + 3; i++) {
            simpleArray.add(i);
        }
    }

}
