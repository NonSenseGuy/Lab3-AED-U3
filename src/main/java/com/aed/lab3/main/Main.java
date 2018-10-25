package com.aed.lab3.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private League league;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/firstScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FIBA");
		primaryStage.show();
	}
	
	private League getLeague() {
		return league;
	}
	
	private void setLeague(League league) {
		this.league = league;
	}
	
	public void createLeague(int i) {
		league = new League(i);
	}
}
