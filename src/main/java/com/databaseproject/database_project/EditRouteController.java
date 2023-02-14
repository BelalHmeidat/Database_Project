package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditRouteController implements Initializable {

    public static Route selectedRoute;

    @FXML
    private TextField editSourceNameField;
    @FXML
    private TextField editDestinationNameField;

    @FXML
    private TextField editRouteCostField;

    @FXML
    private TextField editRouteDurationField;

    @FXML private Label editRouteErrorLabel;


    @FXML
    private void saveEditRouteButtonClicked() {
        if (editSourceNameField.getText().isEmpty()) {
            editRouteErrorLabel.setText("Source name can't be empty!");
            return;
        }
        if (editDestinationNameField.getText().isEmpty()) {
            editRouteErrorLabel.setText("Destination name can't be empty!");
            return;
        }
        if (editRouteCostField.getText().isEmpty()) {
            editRouteErrorLabel.setText("Cost can't be empty!");
            return;
        }
        if (!checkRouteCost(editRouteCostField.getText().trim())) {
            return;
        }
        if (editRouteDurationField.getText().isEmpty()){
            editRouteErrorLabel.setText("Duration can't be empty!");
            return;
        }

        else {
            String sourceName = editSourceNameField.getText().trim();
            String destinationName = editDestinationNameField.getText().trim();
            float cost = Float.parseFloat(editRouteCostField.getText().trim());
            int duration = Integer.parseInt(editRouteDurationField.getText().trim());
            selectedRoute.setFrom(sourceName);
            selectedRoute.setTo(destinationName);
            selectedRoute.setCost(cost);
            selectedRoute.setDuration(duration);
            DataHandler.updateRoutes(); //update SQL Database
            getEditRouteStage().close();
        }


    }

    @FXML
    private void closeEditRouteButtonClicked() {
        getEditRouteStage().close();
    }

    private Stage getEditRouteStage() {
        return (Stage) editSourceNameField.getScene().getWindow();
    }

    private boolean checkRouteCost(String cost) {
        try {
            float salaryFlt = Float.parseFloat(cost);
            if (salaryFlt < 0) {
                editRouteErrorLabel.setText("Cost can't be negative!");
                return false;
            }
        } catch (NumberFormatException e) {
            editRouteErrorLabel.setText("Cost has to be digits only!");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editSourceNameField.setText(selectedRoute.getFrom());
        editDestinationNameField.setText(selectedRoute.getTo());
        editRouteCostField.setText(String.valueOf(selectedRoute.getCost()));
        editRouteDurationField.setText(String.valueOf(selectedRoute.getDuration()));

    }

}
