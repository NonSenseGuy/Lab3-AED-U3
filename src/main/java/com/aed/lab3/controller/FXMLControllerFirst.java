package com.aed.lab3.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All files", "*.*"));
		File file = fileChooser.showOpenDialog(null);
		
		if(file != null) {
			String path = file.getAbsolutePath();
			readCSV(path);
		}
    }
    
    private void readCSV(String path) {
    	
    	String currentLine = "";
    	int limit = 0;
    	
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((currentLine = br.readLine()) != null && limit <= 50) {
				String[] information = currentLine.split(",");
				System.out.println(information[30]);
				limit++;
			}
			
			if(br != null) br.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
}
