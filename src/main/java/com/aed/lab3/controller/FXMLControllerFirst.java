package com.aed.lab3.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.aed.lab3.main.Player;

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
    	int counter = 0;
    	
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			br.readLine();
			while((currentLine = br.readLine()) != null) {
				String[] information = currentLine.split(",");
				double rebounds = Double.valueOf(information[10]) + Double.valueOf(information[11]);
				
				Player temp = new Player(information[2], information[1], Integer.valueOf(information[3]),
						Double.valueOf(information[30]), rebounds, Double.valueOf(information[13]), 
						Double.valueOf(information[14]), Double.valueOf(information[15]));
				
				plainText(counter, temp);
				counter++;
			}
			
			if(br != null) br.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void plainText(int counter, Player player) throws IOException {
    	File file = new File( "./src/main/resources/last/" + counter + ".txt");
    	
    	if(!file.exists()) file.createNewFile();
    	
    	FileWriter fw = new FileWriter(file);
    	BufferedWriter writer = new BufferedWriter(fw);
    	
    	writer.write(player.getName() + "," + player.getTeam() + "," + player.getAge() + "," +
    			player.getPoints() + "," + player.getRebounds() + "," + player.getAssists() + ","
    			+ player.getSteals() + "," + player.getBlocks());
    
    	if(writer != null) writer.close();
    	if(fw != null) fw.close();
    }
}
