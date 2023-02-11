package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.sql.Date;

public class AddOperatorContoller {

    @FXML TextField addOperatorNameField;
    @FXML
    TextField addOperatorPhoneNumberField;

    @FXML TextField addOperatorShiftTypeField;

    @FXML TextField addOperatorAddressField;

    @FXML TextField addOperatorEmailField;

    @FXML DatePicker addOperatorDOBField;

    @FXML
    TextField addOperatorSalaryField;
    @FXML TextField addOperatorPassField;

    @FXML
    Label addOperatorErrorLabel;



    private Stage getOperatorAddStage(){
        return (Stage) addOperatorNameField.getScene().getWindow();
    }

    @FXML public void closeButtonClicked(){
        getOperatorAddStage().close();
    }



    @FXML public void addOperatorButtonClicked(){
        String operatorName = addOperatorNameField.getText().trim();
        if (operatorName.isEmpty()) {
            addOperatorErrorLabel.setText("Name can't be empty!");
            return;
        }
        if (addOperatorPhoneNumberField.getText().isEmpty()){
            addOperatorErrorLabel.setText("Phone number can't be empty!");
            return;
        }
        if (!DataHandler.checkPhoneValidity(addOperatorPhoneNumberField.getText().trim())) {
            addOperatorErrorLabel.setText("Phone number is invalid!");
            return;
        }
        if (addOperatorShiftTypeField.getText().isEmpty()){
            addOperatorErrorLabel.setText("Shift type can't be empty!");
            return;
        }
        if (!addOperatorShiftTypeField.getText().trim().equalsIgnoreCase("Day") || !addOperatorShiftTypeField.getText().trim().equalsIgnoreCase("Night")) {
            addOperatorErrorLabel.setText("Shift type is invalid!");
            return;
        }
        if (addOperatorDOBField.getValue() == null) {
            addOperatorErrorLabel.setText("Date of birth can't be empty!");
            return;
        }
        if (addOperatorSalaryField.getText().isEmpty()){
            addOperatorErrorLabel.setText("Salary can't be empty!");
            return;
        }
        if (addOperatorAddressField.getText().isEmpty()){
            addOperatorErrorLabel.setText("Address can't be empty!");
            return;
        }
        if (addOperatorEmailField.getText().isEmpty()){
            addOperatorErrorLabel.setText("Email can't be empty!");
            return;
        }
        if (!checkSalaryField(addOperatorSalaryField.getText().trim()))
            return;
        if (addOperatorPassField.getText().isEmpty()){
            addOperatorErrorLabel.setText("Password can't be empty!");
            return;
        }
        else {
            Operator operator = new Operator(0, operatorName, addOperatorPhoneNumberField.getText().trim(), addOperatorShiftTypeField.getText().trim(), addOperatorAddressField.getText().trim(), addOperatorEmailField.getText().trim(), Date.valueOf(addOperatorDOBField.getValue().toString()), Float.parseFloat(addOperatorSalaryField.getText().trim()), addOperatorPassField.getText().trim());
            DataHandler.addOperator(operator);
            DataHandler.getAllOperators();
            getOperatorAddStage().close();
        }

    }

    private boolean checkSalaryField(String salary){

        try {
            float salaryFlt = Float.parseFloat(salary);
            if (salaryFlt < 0) {
                addOperatorErrorLabel.setText("Salary can't be negative!");
                return false;
            }
        } catch (NumberFormatException e) {
            addOperatorErrorLabel.setText("Salary has to be digits only!");
            return false;
        }
        return true;
    }
}
