package com.databaseproject.database_project;

import javafx.fxml.FXML;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.sql.Date;

public class AddDriverController {
	@FXML
	private TextField addDriverNamefield;
	@FXML
	private TextField addDriverPhoneNumberField;
	@FXML
	private TextField addDriverAddressField;
	@FXML
	private TextField addDriverEmailField;
	@FXML
	private DatePicker addDriverDateOfBirthField;
	@FXML
	private TextField addDriverShiftTypeField;
	@FXML
	private TextField addDriverLicenceIDField;
	@FXML
	private DatePicker addDriverExpirationDateField;
	@FXML
	private DatePicker addDriverRenewalDateField;


	@FXML private TextField addDriverInsuranceIDField;
	@FXML private TextField addDriverInsuranceCostField;

	@FXML private TextField addDriverInsuranceExpirationDateField;

	@FXML private TextField addDriverInsuranceRenewalDateField;


	@FXML
	Label addDriverErrorLabel;

	// Event Listener on Button.onAction
	@FXML
	public void save_selected_driver_btn_clicked(ActionEvent event) {
		String driverName = addDriverNamefield.getText().trim();
	    if (driverName.isEmpty()) {
	        addDriverErrorLabel.setText("Name can't be empty!");
	        return;
	    }
	    if (addDriverPhoneNumberField.getText().isEmpty()){
	        addDriverErrorLabel.setText("Phone number can't be empty!");
	        return;
	    }
	    if (!DataHandler.checkPhoneValidity(addDriverPhoneNumberField.getText().trim())) {
	        addDriverErrorLabel.setText("Phone number is invalid!");
	        return;
	    }
	    if (addDriverAddressField.getText().isEmpty()){
	    	addDriverErrorLabel.setText("Address type can't be empty!");
	        return;
	    }
	    if (!addDriverShiftTypeField.getText().trim().equalsIgnoreCase("Day") || !addDriverShiftTypeField.getText().trim().equalsIgnoreCase("Night")) {
	    	addDriverErrorLabel.setText("Shift type is invalid!");
	        return;
	    }
	    if (addDriverDateOfBirthField.getValue() == null) {
	    	addDriverErrorLabel.setText("Date of birth can't be empty!");
	        return;
	    }
	    if (addDriverExpirationDateField.getValue()==null){
	    	addDriverErrorLabel.setText("Expiration Date can't be empty!");
	        return;
	    }
	    if (addDriverRenewalDateField.getValue()==null){
	    	addDriverErrorLabel.setText("Renewal Date can't be empty!");
	        return;
	    }
	    if (addDriverEmailField.getText().isEmpty()){
	    	addDriverErrorLabel.setText("Email can't be empty!");
	        return;
	    }
	    if (addDriverLicenceIDField.getText().isEmpty()){
	    	addDriverErrorLabel.setText("Licence ID can't be empty!");
	        return;
	    }
	    if (checkLicence(Integer.parseInt(addDriverLicenceIDField.getText()))==true){
	    	addDriverErrorLabel.setText("Licence ID is already exists!");
	        return;
	    }
	    else {
			DriverLicence licence = new DriverLicence(Integer.parseInt(addDriverLicenceIDField.getText()), Date.valueOf(addDriverExpirationDateField.getValue().toString()), Date.valueOf(addDriverRenewalDateField.getValue().toString()));
	        Driver driver = new Driver(0, driverName, addDriverAddressField.getText().trim(), addDriverPhoneNumberField.getText().trim(), addDriverEmailField.getText().trim(), Date.valueOf(addDriverDateOfBirthField.getValue().toString()), addDriverShiftTypeField.getText().trim());
	        DataHandler.addDriver(driver);
			DataHandler.getAllDrivers();
	        getDriverAddStage().close();
	    }

	}	
	// Event Listener on Button.onAction
	@FXML
	public void close_add_driver_btn_clicked(ActionEvent event) {
        getDriverAddStage().close();
	}

	private Stage getDriverAddStage() {
		return (Stage) addDriverNamefield.getScene().getWindow();
	}

	public static boolean checkLicence(int driverLicensesID){
		for(DriverLicence licence : DriverLicence.driverLicenses){
			if(licence.getLicenseID() == driverLicensesID){
				return true;
			}
		}
		return false;
	}

	public static boolean checkInsurance(int driverInsuranceID){
		for(EmpInsurance insurance : EmpInsurance.empInsurances){
			if(insurance.getInsuranceID() == driverInsuranceID){
				return true;
			}
		}
		return false;
	}
}
