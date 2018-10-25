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
    private ComboBox<String> typeDataStructure;
    
    @FXML
    private ComboBox<String> condition;

    @FXML
    private Label labAge;

    @FXML
    private Label labAssis;

    @Override
	public void initialize(URL location, ResourceBundle resources) {

    	searchChoice.getItems().add("Points% per Match");
    	searchChoice.getItems().add("Rebounds% per Match");
    	searchChoice.getItems().add("Assists% per Match");
    	searchChoice.getItems().add("Steals% per Match");
    	
    	typeDataStructure.getItems().add("AVL Tree");
    	typeDataStructure.getItems().add("Red-Black Tree");
    	typeDataStructure.getItems().add("Binary Search Tree");
    	
    	condition.getItems().add("Equal");
    	condition.getItems().add("Grater");
    	condition.getItems().add("Less");

	}
    
    public League getLeague() {
    	return league;
    }
    
    public void setLeague(League league) {
    	this.league = league;
    }
}
