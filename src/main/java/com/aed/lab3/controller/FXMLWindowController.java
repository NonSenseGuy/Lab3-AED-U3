package com.aed.lab3.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.aed.lab3.main.League;
import com.aed.lab3.main.Player;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

@SuppressWarnings("restriction")
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
    private ListView<Player> listPlayers;
    
    @FXML
    private Button addPlayer, butSearch;
    
    @FXML
    private TextField parameter;

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
    	condition.getItems().add("Greater");
    	condition.getItems().add("Less");

	}
    
    public League getLeague() {
    	return league;
    }
    
    public void setLeague(League league) {
    	this.league = league;
    }
    
    @FXML
    void addPlayerLeague(ActionEvent event) throws IOException {
    	String name = "", team = "";
    	double assists = 0, rebounds = 0, points = 0, blocks = 0, steals = 0;
    	int age;
    	
    	TextInputDialog namePlayer = inputDialog("Name of the player");
    	namePlayer.setTitle("Add Player: Name");
    	Optional<String> resultName = namePlayer.showAndWait();
    	if(resultName.isPresent()) name = resultName.get();
    	else return;
    	
    	TextInputDialog teamPlayer = inputDialog("Team of the player");
    	teamPlayer.setTitle("Add Player: Team");
    	Optional<String> resultTeam = teamPlayer.showAndWait();
    	if(resultName.isPresent()) team = resultTeam.get();
    	else return;
    	
    	TextInputDialog agePlayer = inputDialog("Age of the player");
    	agePlayer.setTitle("Add Player: Age");
    	Optional<String> resultAge = agePlayer.showAndWait();
    	if(resultName.isPresent()) age = Integer.valueOf(resultAge.get());
    	else return;
    	
    	TextInputDialog assistsPlayer = inputDialog("Assist of the player");
    	assistsPlayer.setTitle("Add Player: Assists");
    	Optional<String> resultAssists = assistsPlayer.showAndWait();
    	if(resultName.isPresent()) assists = Double.valueOf(resultAssists.get());
    	else return;
    	
    	TextInputDialog pointsPlayer = inputDialog("Points of the player");
    	pointsPlayer.setTitle("Add Player: Points");
    	Optional<String> resultPoints = pointsPlayer.showAndWait();
    	if(resultName.isPresent()) points = Double.valueOf(resultPoints.get());
    	else return;
    	
    	TextInputDialog blocksPlayer = inputDialog("Blocks of the player");
    	blocksPlayer.setTitle("Add Player: Blocks");
    	Optional<String> resultBlocks = blocksPlayer.showAndWait();
    	if(resultName.isPresent()) blocks = Double.valueOf(resultBlocks.get());
    	else return;
    	
    	TextInputDialog reboundsPlayer = inputDialog("Rebounds of the player");
    	reboundsPlayer.setTitle("Add Player: Rebounds");
    	Optional<String> resultRebounds = reboundsPlayer.showAndWait();
    	if(resultName.isPresent()) rebounds = Double.valueOf(resultRebounds.get());
    	else return;
    	
    	TextInputDialog stealsPlayer = inputDialog("Steals of the player");
    	stealsPlayer.setTitle("Add Player: Steals");
    	Optional<String> resultSteals = stealsPlayer.showAndWait();
    	if(resultName.isPresent()) steals = Double.valueOf(resultSteals.get());
    	else return;
    	
    	league.addPlayer(name, team, age, points, rebounds, assists, steals, blocks);
    	
    }
    
    public TextInputDialog inputDialog(String hint) {
    	TextInputDialog dialog = new TextInputDialog("");
    	dialog.setTitle("Text Input Dialog");
    	dialog.setHeaderText(null);
    	dialog.setContentText("Please enter the " + hint + ": ");
    	dialog.initStyle(StageStyle.UTILITY);
    	return dialog;
    }
    
    @FXML
    void searchPlayer(ActionEvent event) {
    	try {
    		ArrayList<Player> players = null;
    		String typeDE = typeDataStructure.getSelectionModel().getSelectedItem();
    		String typeData = searchChoice.getSelectionModel().getSelectedItem();
    		String logic = condition.getSelectionModel().getSelectedItem();
    		double data = Double.valueOf(parameter.getText());
    		
    		if(typeDE.equals("AVL Tree")) {
    			if(logic.equals("Less")) {
    				players = league.searchLessAVL(data, typeData);
    			}else if(logic == "Greater") {
    				players = league.searchGreaterAVL(data, typeData);
    			}else if(logic == "Equal") {
    				players = league.searchAVL(data, typeData);
    			}
    		}else if(typeDE.equals("Red-Black Tree")) {
    			if(logic.equals("Less")) {
    				System.out.println("Work");
    				players = league.searchLessRB(data, typeData);
    			}else if(logic == "Greater") {
    				players = league.searchGreaterRB(data, typeData);
    			}else if(logic == "Equal") {
    				players = league.searchRB(data, typeData);
    			}
    		}else if(typeDE.equals("Binary Search Tree")) {
    			if(logic.equals("Less")) {
    				players = league.searchLessBST(data, typeData);
    			}else if(logic == "Greater") {
    				players = league.searchGreaterBST(data, typeData);
    			}else if(logic == "Equal") {
    				players = league.searchBST(data, typeData);
    			}
    		}
    		
    		fillListView(players);
    		
    	}catch(Exception e) {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText(null);
        	alert.setContentText("There are fields that incorrect. Check.");
    	}
    }
    
    private void fillListView(ArrayList<Player> players) {
		listPlayers.getItems().clear();
		for(int i = 0; i < players.size(); i++) {
			listPlayers.getItems().add(players.get(i));
		}
	}

	@FXML
    void changeDataSearch(ActionEvent event) {
    	searchChoice.getItems().clear();
    	if(typeDataStructure.getValue() == "AVL Tree") {
    		searchChoice.getItems().add("Rebounds% per Match");
        	searchChoice.getItems().add("Assists% per Match");
    	}else if(typeDataStructure.getValue() == "Red-Black Tree") {
    		searchChoice.getItems().add("Points% per Match");
        	searchChoice.getItems().add("Steals% per Match");
    	}else if(typeDataStructure.getValue() == "Binary Search Tree") {
    		searchChoice.getItems().add("Points% per Match");
        	searchChoice.getItems().add("Assists% per Match");
    	}else {
    		searchChoice.getItems().add("Points% per Match");
        	searchChoice.getItems().add("Rebounds% per Match");
        	searchChoice.getItems().add("Assists% per Match");
        	searchChoice.getItems().add("Steals% per Match");
    	}
    }
    
}
