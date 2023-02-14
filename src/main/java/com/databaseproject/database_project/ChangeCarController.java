package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeCarController implements Initializable {
    public static Driver selectedDriver;
    @FXML private MenuButton carsMenuButton;
    @FXML private Label changeCarErrorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carsMenuButton.getItems().clear();
        for (Car car : DataHandler.getFreeCars()) {
            MenuItem menuItem = new MenuItem(car.getCarID() + " " + car.getCarModel());
            menuItem.setOnAction(actionEvent -> {
                carsMenuButton.setText(menuItem.getText());
            });
            carsMenuButton.getItems().add(menuItem);
        }

    }

    @FXML private void changeCarSaveButtonClicked() {
        if (carsMenuButton.getText().trim().equals("Selected Car")){
            changeCarErrorLabel.setText("Please select a car!");
            return;
        }
        selectedDriver.setCarID(Integer.parseInt(carsMenuButton.getText().trim().split(" ")[0]));
        Car car = Car.getCar(selectedDriver.getCarID());
        if (car.getCarDriver1() <= -1){
            car.setCarDriver2ID(selectedDriver.getDriverID());
        } else {
            car.setCarLiscenceID(selectedDriver.getDriverID());
        }
        DataHandler.updateDrivers();
    }

    @FXML private void changeCarCancelButtonClicked() {
        Stage stage = (Stage) carsMenuButton.getScene().getWindow();
        stage.close();
    }
}
