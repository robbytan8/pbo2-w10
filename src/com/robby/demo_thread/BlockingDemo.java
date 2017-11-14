package com.robby.demo_thread;

import java.util.Scanner;

/**
 *
 * @author Robby
 */
public class BlockingDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        StringBuilder outputBuilder = new StringBuilder("");
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            outputBuilder.append("abc");
        }

        System.out.println("");
    }
}
