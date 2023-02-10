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

public class ManagerLoginController {


    @FXML
    Label managerLoginError;

    @FXML
    TextField managerIDTextField;

    @FXML
    PasswordField managerPasswordField;


    public Stage getMangerLoginStage(){
        return (Stage) managerIDTextField.getScene().getWindow();
    }
    public Stage getMangerLoginStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();

    }
    @FXML
    private void cancelManagerLogin(ActionEvent event) {
        getMangerLoginStage(event).close();
    }

    @FXML
    private void checkManagerLogin(ActionEvent event) {
        String id = managerIDTextField.getText().trim();
        if (id.length() > 20) {
            managerLoginError.setText("ID is too long!");
            return;
        } else if (id.contains(" ")) {
            managerLoginError.setText("ID can't contain spaces!");
            return;
        } else if (id.length() == 0) {
            managerLoginError.setText("ID can't be empty!");
            return;
        }
        String password = managerPasswordField.getText().trim();
        if (password.length() > 20) {
            managerLoginError.setText("Password is too long!");
            return;
        }
        for (Manager manager : Manager.managers) {
            if (id.equals(manager.getUserName())) {
                if (password.equals(manager.getPassword())) {
                    getMangerLoginStage().close();
                    Main.generalLoginStage.close();
                    Stage managerLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    managerLoginStage.close();
                    FXMLLoader mainManagerLoader = new FXMLLoader(getClass().getResource("MainManagerPage.fxml"));
                    Scene mainManagerScene = null;
                    try {
                        mainManagerScene = new Scene(mainManagerLoader.load());

                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    Stage mainManagerStage = new Stage();
                    mainManagerStage.setTitle("Manager Control Panel");
                    mainManagerStage.setScene(mainManagerScene);
                    mainManagerStage.show();
                    return;
                }
            }
        }
        managerLoginError.setText("Wrong ID or Password!");
    }

}
