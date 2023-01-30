package com.databaseproject.database_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainOperatorPage.fxml"));
//        FXMLLoader newTripLoader = new FXMLLoader(Main.class.getResource("newTripWindow.fxml"));
        Scene operatorWorkSpace = new Scene(fxmlLoader.load(), 900, 700);
//        Scene newTripWindow = new Scene(newTripLoader.load(), 900, 400);
//        Stage newTripStage = new Stage();
//        newTripStage.setTitle("New Trip");
        stage.setTitle("Operator Workspace");
        stage.setScene(operatorWorkSpace);
        stage.show();
    }

    public static void main(String[] args) {
        Driver driver = new Driver("Debby Johns1", "1234 Main St", "", "New York", "10001" ,"1234567890", "djohns@taxieswithoutborders.com", "20-10-2001", "8:00 AM - 5:00 PM", true, new Date(1500), "Square");
        launch();
    }
}