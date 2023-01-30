package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class UIController {

//    @FXML
//    TableView driversTable;
//    @FXML
//    TableColumn driverIDColumn;
//
//    @FXML
//    TableColumn driverNameColumn;
//
//    @FXML
//    TableColumn driverPhoneColumn;
//
//    @FXML
//    TableColumn driverEmailColumn;
//
//    @FXML
//    TableColumn driverCityColumn;
//
//    @FXML
//    TableColumn driverWorkHoursColumn;
//
//    @FXML
//    TableColumn driverLocationColumn;
//
//    @FXML
//    TableColumn driverAvailabilityColumn;
//
//    @FXML
//    TableColumn driverExpectedAvailabilityTimeColumn;


    void intilize() {
//        driverIDColumn.setCellValueFactory(new PropertyValueFactory<>("driverID"));
//        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        driverPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
//        driverCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
//        driverEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//        driverWorkHoursColumn.setCellValueFactory(new PropertyValueFactory<>("workHours"));
//        driverLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
//        driverAvailabilityColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
//        driverExpectedAvailabilityTimeColumn.setCellValueFactory(new PropertyValueFactory<>("expectedAvailabilityTime"));
//        for (Driver driver : Driver.drivers){
//            if (driver.isWorking) {
//                driversTable.getItems().add(driver);
//            }

//        }
    }
    static FXMLLoader newTripLoader = new FXMLLoader(Main.class.getResource("newTripWindow.fxml"));
    static Stage newTripStage = new Stage();
    static {

        Scene newTripWindow = null;
        try {
            newTripWindow = new Scene(newTripLoader.load(), 500, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        newTripStage.setTitle("New Trip");
        newTripStage.setScene(newTripWindow);
    }
    @FXML
    protected void onMakeNewTripClick() {
        newTripStage.show();
    }

//        intilize();


}