package com.aed.lab3.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLControllerFirst {
	
	@FXML
    private Button butStartData;

    @FXML
    private Button butCsvFile;

    @FXML
    private Button butStartCero;
    
    @FXML
    private AnchorPane rootPane;
    
    private FileChooser fileChooser;
    
    @FXML
    void startScratch(ActionEvent event) throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/window.fxml"));
    	rootPane.getChildren().setAll(pane);
    }
    
    @FXML
    void chargeCsv(ActionEvent event) {
    	fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("CSV Files", ".csv"));
    }
}
