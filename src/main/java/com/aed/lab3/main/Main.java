package com.aed.lab3.main;

import com.aed.lab3.generic.AVLTree;
import com.aed.lab3.generic.AVLTreeNode;
import com.aed.lab3.generic.RBBinaryTree;
import com.aed.lab3.generic.RBTreeNode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	
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
	
}
