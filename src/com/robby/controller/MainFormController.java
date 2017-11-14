package com.robby.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author Robby
 */
public class MainFormController implements Initializable {

    @FXML
    private Label lblProgress;
    @FXML
    private Label lblTask;
    @FXML
    private ProgressBar progressBar;
    private ProgressTask progressTask;
    private ExecutorService executorService;

    @FXML
    private void btnReadAction(ActionEvent event) {
        lblTask.setText(progressTask.getState().toString());
    }

    @FXML
    private void btnStartAction(ActionEvent event) {
        executorService.execute(progressTask);
        executorService.shutdown();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progressTask = new ProgressTask();
        executorService = Executors.newCachedThreadPool();
        lblProgress.textProperty().bind(progressTask.messageProperty());
        progressBar.setProgress(0);
        progressBar.progressProperty().bind(progressTask.progressProperty());
    }

}
