package com.aed.lab3.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.aed.lab3.main.League;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;

public class FXMLWindowController implements Initializable{
	
	private League league;

    @FXML
    private Label labBlocks, labAge, labAssis, labSteal, labTeam, labName, labPoints, labRebound;
    
    @FXML
    private ComboBox<String> searchChoice;
    
    @FXML
    private ComboBox<String> typeDataStructure;
    
    @FXML
    private ComboBox<String> condition;
    
    @FXML
    private Button addPlayer;

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
    
    @FXML
    void addPlayerLeague(ActionEvent event) {
    	String namePlayer = "";
    	
    	TextInputDialog name = inputDialog("name of the player");
    	Optional<String> resultName = name.showAndWait();
    	if(resultName.isPresent()) namePlayer = resultName.get();
    	
    }
    
    public TextInputDialog inputDialog(String hint) {
    	TextInputDialog dialog = new TextInputDialog("Option");
    	dialog.setTitle("Text Input Dialog");
    	dialog.setHeaderText(null);
    	dialog.setContentText("Please enter the " + hint + ": ");
    	return dialog;
    }
    
}
