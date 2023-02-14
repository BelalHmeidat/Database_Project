package com.databaseproject.database_project;

import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
public class AddRouteController  {

    @FXML
    private TextField addSourceNameField;
    @FXML
    private TextField addDestinationNameField;

    @FXML
    private TextField addRouteCostField;

    @FXML
    private TextField addRouteDurationField;

    @FXML
    private Label addRouteErrorLabel;

    public void save_selected_Rout_btn_clicked(ActionEvent event) {
        String SourceName = addSourceNameField.getText().trim();
        if (SourceName.isEmpty()) {
            addRouteErrorLabel.setText("SourceName can't be empty!");
            return;
        }
        if (addDestinationNameField.getText().isEmpty()) {
            addRouteErrorLabel.setText("Destination Name can't be empty!");
            return;
        }
        if (addRouteCostField.getText().isEmpty()) {
            addRouteErrorLabel.setText("Route Cost can't be empty!");
            return;
        }
        if (!checkRouteCost(addRouteCostField.getText().trim())) {
            return;
        }
        if (addRouteDurationField.getText().isEmpty()) {
            addRouteErrorLabel.setText("Duration can't be empty!");
            return;
        } else {
            Route route = new Route(0, SourceName, addDestinationNameField.getText().trim(), Float.parseFloat(addRouteCostField.getText().trim()), Integer.parseInt(addRouteDurationField.getText().trim()));
            DataHandler.addRoute(route);
            DataHandler.getAllRoutes();
            ;
            getRouteAddStage().close();
        }

    }
    private boolean checkRouteCost(String cost) {
        try {
            float salaryFlt = Float.parseFloat(cost);
            if (salaryFlt < 0) {
                addRouteErrorLabel.setText("Cost can't be negative!");
                return false;
            }
        } catch (NumberFormatException e) {
            addRouteErrorLabel.setText("Cost has to be digits only!");
            return false;
        }
        return true;
    }
    // Event Listener on Button.onAction
    @FXML
    public void close_add_driver_btn_clicked(ActionEvent event) {
        getRouteAddStage().close();
    }

    private Stage getRouteAddStage() {
        return (Stage) addSourceNameField.getScene().getWindow();
    }




}
