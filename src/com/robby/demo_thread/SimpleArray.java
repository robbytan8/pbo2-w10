package com.robby.demo_thread;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author Robby
 */
public class SimpleArray {

    private static final SecureRandom generator = new SecureRandom();
    private final int[] array;
    private int writeIndex;

    public SimpleArray(int size) {
        array = new int[size];
    }

    public void add(int value) {
        int position = writeIndex;
        try {
            Thread.sleep(generator.nextInt(500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //  put value to array
        array[position] = value;
        System.out.printf("%s wrote %2d to element %d.%n", Thread.currentThread().getName(), value, position);
        writeIndex++;
        System.out.printf("Next write index " + writeIndex + "%n");
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
