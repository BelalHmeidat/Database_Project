package com.databaseproject.database_project;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
public class EditCarController implements Initializable{



    public static Car selectedCar;

    @FXML private Label editCarErrorLabel;
    @FXML
    private TextField EditCarTypeField;
    @FXML
    private TextField EditCarYOMfield;

    @FXML
    private TextField EditCarLicenceID;

    @FXML
    private TextField EditCarLicenceRenewalDateField;
    @FXML
    private TextField EditCarLicenceExpirationDateField;


    @FXML private TextField editCarInsuranceID;

    @FXML private TextField editCarInsuranceExpirationDate;

    @FXML private TextField editCarInsuranceRenwalDate;

    @FXML private TextField editCarInsuranceCost;



    @FXML
    private void saveEditRouteButtonClicked() {
        if (EditCarTypeField.getText().isEmpty()) {
            editCarErrorLabel.setText("Car model can't be empty!");
            return;
        }
        if (EditCarYOMfield.getText().isEmpty()) {
            editCarErrorLabel.setText("year of made can't be empty!");
            return;
        }
        if (EditCarLicenceID.getText().isEmpty()) {
            editCarErrorLabel.setText("Licence ID can't be empty!");
            return;
        }
        if (checkLicence(Integer.parseInt(EditCarLicenceID.getText()))==true){
            editCarErrorLabel.setText("Licence ID is already exists!");
            return;
        }

        if (EditCarLicenceRenewalDateField.getText().isEmpty()) {
            editCarErrorLabel.setText("Licence's Renewal Date can't be empty!");
            return;
        }
        if (EditCarLicenceExpirationDateField.getText().isEmpty()) {
            editCarErrorLabel.setText("Licence's Expiration Date can't be empty!");
            return;
        }
        if (editCarInsuranceID.getText().isEmpty()){
            editCarErrorLabel.setText("Insurance's ID can't be empty!");
            return;
        }
        if (editCarInsuranceExpirationDate.getText().isEmpty()){
            editCarErrorLabel.setText("Insurance's Expiration Date can't be empty!");
            return;
        }
        if (editCarInsuranceRenwalDate.getText().isEmpty()){
            editCarErrorLabel.setText("Insurance's  Renwal Date can't be empty!");
            return;
        }
        if (editCarInsuranceRenwalDate.getText().isEmpty()){
            editCarInsuranceCost.setText("Insurance's  Cost can't be empty!");
            return;
        }
        if (!checkInsuranceCost(editCarInsuranceCost.getText().trim())) {
            return;
        }


        else {
            String CarType = EditCarTypeField.getText().trim();
            int CarYOM = Integer.parseInt(EditCarYOMfield.getText().trim());
            int LicenceID = Integer.parseInt(EditCarLicenceID.getText().trim());
            Date LicenceRenewalDate= Date.valueOf(EditCarLicenceRenewalDateField.getText().trim());
            Date LicenceExpirationDate= Date.valueOf(EditCarLicenceExpirationDateField.getText().trim());
            int InsuranceID = Integer.parseInt(editCarInsuranceID.getText().trim());
            Date InsuranceRenewalDate= Date.valueOf(editCarInsuranceRenwalDate.getText().trim());
            Date InsuranceExpirationDate= Date.valueOf(editCarInsuranceExpirationDate.getText().trim());


            float cost = Float.parseFloat(editCarInsuranceCost.getText().trim());
            int duration = Integer.parseInt(editCarInsuranceCost.getText().trim());
            selectedCar.setCarModel(CarType);
            selectedCar.setCarLiscenceID(LicenceID);
            selectedCar.setCarInsuranceID(InsuranceID);
            selectedCar.setYearOfMan(CarYOM);
            DataHandler.getAllCars(); //update SQL Database
            getEditCarStage().close();
        }


    }

    @FXML
    private void closeEditRouteButtonClicked() {
        getEditCarStage().close();
    }

    private Stage getEditCarStage() {
        return (Stage) EditCarTypeField.getScene().getWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EditCarTypeField.setText(selectedCar.getCarModel());
        EditCarYOMfield.setText(String.valueOf(selectedCar.getYearOfMan()));
        EditCarLicenceID.setText(String.valueOf(selectedCar.getCarLiscenceID()));
        editCarInsuranceID.setText(String.valueOf(selectedCar.getCarInsuranceID()));

    }
    public static boolean checkLicence(int carLicensesID){
        for(CarLicense carLicenses : CarLicense.carLicenses){
            if(carLicenses.getLicenseID() == carLicensesID){
                return true;
            }
        }
        return false;
    }
    private boolean checkInsuranceCost(String cost) {
        try {
            float salaryFlt = Float.parseFloat(cost);
            if (salaryFlt < 0) {
                editCarErrorLabel.setText("Cost can't be negative!");
                return false;
            }
        } catch (NumberFormatException e) {
            editCarErrorLabel.setText("Cost has to be digits only!");
            return false;
        }
        return true;
    }

}
