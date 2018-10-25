package com.aed.lab3.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.aed.lab3.main.League;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class FXMLWindowController implements Initializable{
	
	private League league;

    @FXML
    private Label labRebound;

    @FXML
    private Label labPoints;

    @FXML
    private Label labName;

    @FXML
    private Label labTeam;

    @FXML
    private Label labSteal;

    @FXML
    private Label labBlocks;
    
    @FXML
    private ComboBox<String> searchChoice;

    @FXML
    private Label labAge;

    @FXML
    private Label labAssis;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
<<<<<<< HEAD
    	
    	searchChoice.getItems().add("Points per Match");
    	searchChoice.getItems().add("Rebounds per Match");
    	searchChoice.getItems().add("Assists per Match");
    	searchChoice.getItems().add("Steals per Match");
    	searchChoice.getItems().add("Blocks per Match");
=======
    	searchChoice.getItems().add("Points% per Match");
    	searchChoice.getItems().add("Rebounds% per Match");
    	searchChoice.getItems().add("Assists% per Match");
    	searchChoice.getItems().add("Steals% per Match");
    	searchChoice.getItems().add("Blocks% per Match");
>>>>>>> 1dc2e7d280bd7e3c3110830854a1a9748ae7ad43
	}
    
    public League getLeague() {
    	return league;
    }
    
    public void setLeague(League league) {
    	this.league = league;
    }
}
