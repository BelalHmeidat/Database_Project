package com.databaseproject.database_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class OperatorLoginController {

    @FXML
    TextField operatorIDTextField;
    @FXML
    PasswordField operatorPasswordField;

    @FXML
    Label operatorLoginError;

    public Stage getOpertatorLoginStage(){
        return (Stage) operatorIDTextField.getScene().getWindow();
    }

    public Stage getOperatorLoginStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    @FXML
    private void cancelOperatorLogin(ActionEvent event){
        getOperatorLoginStage(event).close();
    }

    @FXML
    private void checkOperatorLogin() {
        int operatorID = -1;
        String id = operatorIDTextField.getText().trim();
        if (id.length() != 3) {
            operatorLoginError.setText("ID has to be 3 digits!");
            return;
        }
        try {
            operatorID = Integer.parseInt(id);
            if (operatorID < 0) {
                operatorLoginError.setText("ID has to be positive!");
                return;
            }
        } catch (NumberFormatException e) {
            operatorLoginError.setText("ID has to be digits only!");
            return;
        }
        String password = operatorPasswordField.getText().trim();
        if (password.length() > 20) {
            operatorLoginError.setText("Password is too long!");
            return;
        }
        for (Operator operator : Operator.operators) {
            if (operatorID == operator.getOperatorID()) {
                if (password.equals(operator.getOperatorPassword())) {
                    getOpertatorLoginStage().close();
                    Main.generalLoginStage.close();
                    Operator.activeOperator = operator;
                    FXMLLoader operatorMainLoader = new FXMLLoader(getClass().getResource("mainOperatorPage.fxml"));
                    Scene mainOperatorScene = null;
                    try {
                        mainOperatorScene = new Scene(operatorMainLoader.load());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage mainOperatorStage = new Stage();
                    mainOperatorStage.setScene(mainOperatorScene);
                    mainOperatorStage.show();
                    return;
                }
            }
        }
        operatorLoginError.setText("Wrong ID or Password!");
    }
}
