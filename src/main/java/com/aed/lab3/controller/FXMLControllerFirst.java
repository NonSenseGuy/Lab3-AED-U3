package com.aed.lab3.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import com.aed.lab3.main.League;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/window.fxml"));
    	loader.load();
    	
    	FXMLWindowController window = loader.getController();
    	window.setLeague(new League());
    	
    	Parent parent = loader.getRoot();
    	Stage stage =  new Stage();
    	stage.setScene(new Scene(parent));
    	stage.setTitle("FIBA");
    	stage.showAndWait();
    }
    
    @FXML
    void chargeCsv(ActionEvent event) throws IOException {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Confirmation Dialog");
    	alert.setHeaderText(null);
    	alert.setContentText("The CSV file have to be separated with comma , make sure of it.");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
 
    	} else {
    		return;
    	}
    	
    	fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All files", "*.*"));
		File file = fileChooser.showOpenDialog(null);
		
		if(file != null) {
			String path = file.getAbsolutePath();
			createLeagueCsv(path);
		}
    }
    
    private void createLeagueCsv(String path) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/view/window.fxml"));
    	loader.load();
    	
    	FXMLWindowController window = loader.getController();
    	window.setLeague(new League());
    	window.getLeague().readCSV(path);
    	
    	Parent parent = loader.getRoot();
    	Stage stage =  new Stage();
    	stage.setScene(new Scene(parent));
    	stage.setTitle("FIBA");
    	stage.showAndWait();
    	
    }
    
    
}
