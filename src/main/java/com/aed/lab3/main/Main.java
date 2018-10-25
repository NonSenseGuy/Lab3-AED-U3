package com.aed.lab3.main;

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
	
	public static void printInorder(RBTreeNode<Double,String> node) {
	     if (node == null) 
	            return; 
	  
	        /* first recur on left child */
	        printInorder(node.getLeft()); 
	  
	        /* then print the data of node */
	        System.out.print(node.getKey() + " "); 
	  
	        /* now recur on right child */
	        printInorder(node.getRight()); 
	}
}
