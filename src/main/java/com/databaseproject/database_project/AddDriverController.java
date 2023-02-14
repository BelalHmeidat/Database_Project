package com.databaseproject.database_project;

import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import javafx.event.ActionEvent;

import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddDriverController implements Initializable {
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

	@FXML
	MenuButton addDriverSelectCarMenuButton;




	@FXML private TextField addDriverInsuranceIDField;
	@FXML private TextField addDriverInsuranceCostField;

	@FXML private DatePicker addDriverInsuranceExpirationDateField;

	@FXML private DatePicker addDriverInsuranceRenewalDateField;


	@FXML
	Label addDriverErrorLabel;

	// Event Listener on Button.onAction
	@FXML
	public void save_selected_driver_btn_clicked(ActionEvent event) {
		String driverName = addDriverNamefield.getText().trim();
		DataHandler.getAllCars();
		DataHandler.getAllDrivers();
		DataHandler.getAllEmpsInsurances();
		DataHandler.getAllDriversLicenses();
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
	    if (!addDriverShiftTypeField.getText().trim().equalsIgnoreCase("Day") && !addDriverShiftTypeField.getText().trim().equalsIgnoreCase("Night")) {
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
		if (addDriverInsuranceIDField.getText().isEmpty()){
			addDriverErrorLabel.setText("Insurance ID can't be empty!");
			return;
		}
		if (checkInsurance(Integer.parseInt(addDriverInsuranceIDField.getText()))==true){
			addDriverErrorLabel.setText("Insurance ID is already exists!");
			return;
		}
		if (addDriverInsuranceCostField.getText().isEmpty()){
			addDriverErrorLabel.setText("Insurance Cost can't be empty!");
			return;
		}
		if (addDriverInsuranceExpirationDateField.getValue()==null){
			addDriverErrorLabel.setText("Insurance Expiration Date can't be empty!");
			return;
		}
		if (addDriverInsuranceRenewalDateField.getValue()==null){
			addDriverErrorLabel.setText("Insurance Renewal Date can't be empty!");
			return;
		}

		if (addDriverSelectCarMenuButton.getText().equals("Select Car")){
			addDriverErrorLabel.setText("Car can't be empty!");
			return;
		}
	    else {
			Car car = Car.getCar(Integer.parseInt(addDriverSelectCarMenuButton.getText().trim().split(" ")[0]));
			EmpInsurance insurance = new EmpInsurance(Integer.parseInt(addDriverInsuranceIDField.getText()), Float.parseFloat(addDriverInsuranceCostField.getText()), Date.valueOf(addDriverInsuranceExpirationDateField.getValue().toString()), Date.valueOf(addDriverInsuranceRenewalDateField.getValue().toString()));
			DriverLicence licence = new DriverLicence(Integer.parseInt(addDriverLicenceIDField.getText()), Date.valueOf(addDriverExpirationDateField.getValue().toString()), Date.valueOf(addDriverRenewalDateField.getValue().toString()));
	        Driver driver = new Driver(0, driverName, addDriverAddressField.getText().trim(), addDriverPhoneNumberField.getText().trim(), addDriverEmailField.getText().trim(), LocalDate.parse(addDriverDateOfBirthField.getValue().toString()), addDriverShiftTypeField.getText().trim(), true, true, addDriverAddressField.getText().trim(), car.getCarID(), insurance.getInsuranceID(), licence.getLicenseID());
			DataHandler.addDriverLicence(licence);
			DataHandler.addDriverInsurance(insurance);
	        DataHandler.addDriver(driver);
			DataHandler.getAllDrivers();
			DataHandler.getAllDriversLicenses();
			DataHandler.getAllEmpsInsurances();
	        getDriverAddStage().close();
	    }

	}	
	// Event Listener on Button.onAction
	@FXML
	public void close_add_driver_btn_clicked() {
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

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		DataHandler.getAllCars();
		for (Car car : Car.cars) {
			if (DataHandler.checkCarFreeForDriver(car.getCarID())) {
				MenuItem menuItem = new MenuItem(car.getCarID() + " " + car.getCarModel());
				menuItem.setOnAction(actionEvent -> addDriverSelectCarMenuButton.setText(menuItem.getText()));
				addDriverSelectCarMenuButton.getItems().add(menuItem);
			}
		}
	}
}
