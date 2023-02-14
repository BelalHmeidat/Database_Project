package com.databaseproject.database_project;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.sql.Date;

public class AddCarController {


    @FXML
    private TextField AddCarTypeField;
    @FXML
    private TextField AddCarYOMfield;
    @FXML
    private TextField addCarLicenceIDField;
    @FXML private TextField addCarInsuranceIDField;
    @FXML
    private DatePicker addCarLicenceExpirationDateField;
    @FXML
    private DatePicker addCarLicenceRenewalDateField;
    @FXML
    private Label addCarErrorLabel;
    @FXML private DatePicker addCarInsuranceExpirationDate;

    @FXML private DatePicker addCarInsuranceRenwalDate;
    @FXML private TextField addCatInsuranceCost;



    // Event Listener on Button.onAction
    @FXML
    public void Add_Car_btn(ActionEvent event) {
        String CarModel = AddCarTypeField.getText().trim();
        if (CarModel.isEmpty()) {
            addCarErrorLabel.setText("Model can't be empty!");
            return;
        }
        if (AddCarYOMfield.getText() == null) {
            addCarErrorLabel.setText("Year of made can't be empty!");
            return;
        }
        if (addCarLicenceExpirationDateField.getValue()==null){
            addCarErrorLabel.setText("Licence's Expiration Date can't be empty!");
            return;
        }
        if (addCarLicenceRenewalDateField.getValue()==null){
            addCarErrorLabel.setText("Licence's Renewal Date can't be empty!");
            return;
        }
        if (addCarInsuranceExpirationDate.getValue()==null){
            addCarErrorLabel.setText("Insurance Expiration Date can't be empty!");
            return;
        }
        if (addCarInsuranceRenwalDate.getValue()==null){
            addCarErrorLabel.setText("Insurance Renewal Date can't be empty!");
            return;
        }
        if (addCarLicenceIDField.getText().isEmpty()){
            addCarErrorLabel.setText("Licence's ID can't be empty!");
            return;
        }
        if (addCarInsuranceIDField.getText().isEmpty()){
            addCarErrorLabel.setText("Insurance's ID can't be empty!");
            return;
        }
        if (checkLicence(Integer.parseInt(addCarLicenceIDField.getText()))==true){
            addCarErrorLabel.setText("Licence's ID is already exists!");
            return;
        }
        if (checkInsurance(Integer.parseInt(addCarInsuranceIDField.getText()))==true){
            addCarErrorLabel.setText("Insurance's ID is already exists!");
            return;
        }
        if (addCatInsuranceCost.getText().isEmpty()) {
            addCarErrorLabel.setText("Cost can't be empty!");
            return;
        }
        if (!checkInsuranceCost(addCatInsuranceCost.getText().trim())) {
            return;
        }
        else {
            CarInsurance insurance = new CarInsurance(Integer.parseInt(addCarInsuranceIDField.getText()), Date.valueOf(addCarLicenceExpirationDateField.getValue()), Date.valueOf(addCarLicenceRenewalDateField.getValue()), Float.parseFloat(addCatInsuranceCost.getText()));
            CarLicense license = new CarLicense(Integer.parseInt(addCarLicenceIDField.getText()), Date.valueOf(addCarLicenceExpirationDateField.getValue()), Date.valueOf(addCarLicenceRenewalDateField.getValue()));
            Car car = new Car(0, CarModel,Integer.parseInt( AddCarYOMfield.getText().trim()),Integer.parseInt(addCarLicenceIDField.getText()), Integer.parseInt(addCarInsuranceIDField.getText()));
            DataHandler.addCarInsurance(insurance);
            DataHandler.addCarLicense(license);
            DataHandler.addCar(car);
            getCarAddStage().close();
        }

    }

    private Stage getCarAddStage() {
        return(Stage) addCarErrorLabel.getScene().getWindow();
    }

    // Event Listener on Button.onAction
    @FXML
    public void close_add_Car_btn(ActionEvent event) {
        getCarAddStage().close();
    }
    public static boolean checkLicence(int carLicensesID){
        for(CarLicense carLicenses : CarLicense.carLicenses){
            if(carLicenses.getLicenseID() == carLicensesID){
                return true;
            }
        }
        return false;
    }
    public static boolean checkInsurance(int carInsuranceID){
        for(CarInsurance CarInsurances : CarInsurance.CarInsurances){
            if(CarInsurances.getInsuranceID() == carInsuranceID){
                return true;
            }
        }
        return false;
    }
    private boolean checkInsuranceCost(String cost) {
        try {
            float salaryFlt = Float.parseFloat(cost);
            if (salaryFlt < 0) {
                addCarErrorLabel.setText("Cost can't be negative!");
                return false;
            }
        } catch (NumberFormatException e) {
            addCarErrorLabel.setText("Cost has to be digits only!");
            return false;
        }
        return true;
    }
}

