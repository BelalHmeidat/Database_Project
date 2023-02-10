package com.databaseproject.database_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;


public class Main extends Application {
    static Stage generalLoginStage = null;
//    static Connection connection = null;
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader generalLoginPage = new FXMLLoader(Main.class.getResource("GeneralLoginPage.fxml"));

        Scene loginMainScene = new Scene(generalLoginPage.load(), 600, 350);
//        Scene newTripWindow = new Scene(newTripLoader.load(), 900, 400);
//        Stage newTripStage = new Stage();
//        newTripStage.setTitle("New Trip");
        stage.setTitle("General Login");
        stage.setScene(loginMainScene);
        stage.show();
        generalLoginStage = stage;
        DataHandler.run();
    }

    public static void main(String[] args) {
        DataHandler.run();
        launch();
    }
}