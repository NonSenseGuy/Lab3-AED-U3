package com.aed.lab3.controller;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class FXMLWindowController implements Initializable{

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
    private Label labAge;

    @FXML
    private Label labAssis;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
//		searchChoice.getItems().add("Points per Match");
//		searchChoice.getItems().add("Rebounds per Match");
//		searchChoice.getItems().add("Assistances per Match");
//		searchChoice.getItems().add("Steals per Match");
//		searchChoice.getItems().add("Blocks per Match");
	}
}
