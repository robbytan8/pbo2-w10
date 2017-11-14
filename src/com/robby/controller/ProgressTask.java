package com.robby.controller;

import javafx.concurrent.Task;

/**
 *
 * @author Robby
 */
public class ProgressTask extends Task<Void> {

    @Override
    protected Void call() throws Exception {
        int max = 100;
        for (int i = 1; i <= max; i++) {
            if (isCancelled()) {
                break;
            }
            updateProgress(i, max);
            updateMessage(String.valueOf(i));
            Thread.sleep(100);
        }
        return null;
    }

}
