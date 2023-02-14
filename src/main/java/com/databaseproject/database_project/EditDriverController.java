package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditDriverController implements Initializable{
    public Driver selectedDriver;

    @FXML
    private TextField editDriverNameField;
    @FXML
    private TextField editDriverPhoneNumberField;
    @FXML
    private TextField editDriverAddressField;
    @FXML
    private TextField editDriverEmailField;
    @FXML
    private DatePicker editDriverDateOfBirthField;
    @FXML
    private TextField editDriverShiftTypeField;
    @FXML
    private TextField editDriverLicenceIDField;
    @FXML
    private DatePicker editDriverLicenceRenewalDateField;
    @FXML
    private  DatePicker editDriverLicenceExpirationDateField;

    @FXML private TextField editDriverInsuranceIDField;

    @FXML private DatePicker editDriverInsuranceExpirationDateField;

    @FXML private DatePicker editDriverInsuranceRenewalDateField;

    @FXML private TextField editDriverInsuranceCost;

    @FXML private Label editDriverErrorLabel;
    @FXML private void saveEditDriverButtonClicked() {
        if (editDriverNameField.getText().isEmpty()) {
            editDriverErrorLabel.setText(" Name can't be empty!");
            return;
        }
        if (editDriverPhoneNumberField.getText().isEmpty()) {
            editDriverErrorLabel.setText("Phone number can't be empty!");
            return;
        }
        if (editDriverAddressField.getText().isEmpty()) {
            editDriverErrorLabel.setText("Address can't be empty!");
            return;
        }
        if (editDriverEmailField.getText().isEmpty()) {
            editDriverErrorLabel.setText("Email can't be empty!");
            return;
        }
        if (editDriverDateOfBirthField.getValue() == null) {
            editDriverErrorLabel.setText("DOB can't be empty!");
            return;
        }
        if (editDriverShiftTypeField.getText().isEmpty()) {
            editDriverErrorLabel.setText("Shift type can't be empty!");
            return;
        }
        if (editDriverLicenceIDField.getText().isEmpty()) {
            editDriverErrorLabel.setText("LicenceID can't be empty!");
            return;
        }
        if (editDriverLicenceRenewalDateField.getValue() == null) {
            editDriverErrorLabel.setText("Licence Renewal Date can't be empty!");
            return;
        }
        if (editDriverLicenceExpirationDateField.getValue() == null) {
            editDriverErrorLabel.setText("Licence Expiration Date can't be empty!");
            return;
        }
        if (editDriverInsuranceIDField.getText().isEmpty()) {
            editDriverErrorLabel.setText("InsuranceID can't be empty!");
            return;
        }
        if (editDriverInsuranceExpirationDateField.getValue() == null) {
            editDriverErrorLabel.setText("Insurance expiration date can't be empty!");
            return;
        }
        if (editDriverInsuranceRenewalDateField.getValue() == null) {
            editDriverErrorLabel.setText("Insurance renewal date can't be empty!");
            return;
        }
        if (editDriverInsuranceCost.getText().isEmpty()) {
            editDriverErrorLabel.setText("Cost can't be empty!");
            return;
        }


        else {
            String DriverName = editDriverNameField.getText().trim();
            String DriverPhoneNumber = editDriverPhoneNumberField.getText().trim();
            String DriverAddress = editDriverAddressField.getText().trim();
            String DriverEmailField = editDriverEmailField.getText().trim();
            LocalDate DriverDateOfBirth = editDriverDateOfBirthField.getValue();
            String DriverShiftType = editDriverShiftTypeField.getText().trim();
            int DriverLicenceID = Integer.parseInt(editDriverLicenceIDField.getText().trim());
            LocalDate DriverLicenceRenewalDate = editDriverLicenceRenewalDateField.getValue();
            LocalDate DriverLicenceExpirationDate = editDriverLicenceExpirationDateField.getValue();
            int DriverInsuranceID = Integer.parseInt(editDriverInsuranceIDField.getText().trim());
            LocalDate DriverInsuranceRenewalDate = editDriverInsuranceExpirationDateField.getValue();
            LocalDate DriverInsuranceExpirationDate = editDriverInsuranceRenewalDateField.getValue();
            float DriverInsuranceCost = Float.parseFloat(editDriverInsuranceCost.getText().trim());

            selectedDriver.setName(DriverName);
            selectedDriver.setPhone(DriverPhoneNumber);
            selectedDriver.setCity(DriverAddress);
            selectedDriver.setEmail(DriverEmailField);
            selectedDriver.setDOB(DriverDateOfBirth);
            selectedDriver.setWorkHours(DriverShiftType);
            selectedDriver.setLicence(DriverLicenceID);
            selectedDriver.setInsurance(DriverInsuranceID);
            DataHandler.updateDrivers(); //update SQL Database
            getEditDriverStage().close();
        }
    }
    @FXML
    private void closeEditDriverButtonClicked() {
        getEditDriverStage().close();
    }

    private Stage getEditDriverStage() {
        return (Stage) editDriverNameField.getScene().getWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataHandler.getAllDriversLicenses();
        DataHandler.getAllEmpsInsurances();
        selectedDriver = Driver.activeDriver;
        editDriverNameField.setText(selectedDriver.getName());
        editDriverPhoneNumberField.setText(String.valueOf(selectedDriver.getPhone()));
        editDriverAddressField.setText(String.valueOf(selectedDriver.getCity()));
        editDriverEmailField.setText(String.valueOf(selectedDriver.getEmail()));
        editDriverDateOfBirthField.setValue((selectedDriver.getDOB()));
        editDriverShiftTypeField.setText(String.valueOf(selectedDriver.getWorkHours()));
        editDriverLicenceIDField.setText(String.valueOf(selectedDriver.getLicenceID()));
        editDriverInsuranceIDField.setText(String.valueOf(selectedDriver.getInsurance()));
        editDriverInsuranceCost.setText(String.valueOf(EmpInsurance.getInsurance(selectedDriver.getInsuranceID()).getCost()));
        editDriverInsuranceRenewalDateField.setValue(EmpInsurance.getInsurance(selectedDriver.getInsuranceID()).getRenwalDate().toLocalDate());
        editDriverInsuranceExpirationDateField.setValue(EmpInsurance.getInsurance(selectedDriver.getInsuranceID()).getExpirationDate().toLocalDate());
        editDriverLicenceExpirationDateField.setValue(DriverLicence.getLicense(selectedDriver.getLicenceID()).getExpirationDate().toLocalDate());
        editDriverLicenceRenewalDateField.setValue(DriverLicence.getLicense(selectedDriver.getLicenceID()).getRenewalDate().toLocalDate());

    }
    public static boolean checkLicence(int driverLicensesID){
        for(DriverLicence driverLicenses : DriverLicence .driverLicenses)
            if (driverLicenses.getLicenseID() == driverLicensesID) {
                return true;
            }
        return false;
    }
    private boolean checkInsuranceCost(String cost) {
        try {
            float costFlt = Float.parseFloat(cost);
            if (costFlt < 0) {
                editDriverErrorLabel.setText("Cost can't be negative!");
                return false;
            }
        } catch (NumberFormatException e) {
            editDriverErrorLabel.setText("Cost has to be digits only!");
            return false;
        }
        return true;
    }




}
