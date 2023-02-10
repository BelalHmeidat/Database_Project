package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GeneralLoginController {

    static private Stage generalLoginStage;

    @FXML
    ImageView managerAvatar;
    @FXML
    ImageView operatorAvatar;
    @FXML
    Text adminLoginCaption;
    @FXML
    Text operatorLoginCaption;

//    static public Stage getGeneralLoginStage() {
//        Scene currentScene = managerAvatar.getScene();
//        return (Stage) currentScene.getWindow();
//    }


    @FXML
    public void showManagerLoginPage() {
        Manager.managers = DataHandler.getManagers();
        try {
            FXMLLoader managerLoginLoader = new FXMLLoader();
            Pane root = managerLoginLoader.load(getClass().getResource("AdminLoginPage.fxml").openStream());
            Stage managerLoginStage = new Stage();
            managerLoginStage.setTitle("Manager Login");
            Scene managerLoginWindow = new Scene(root, 300, 200);
            managerLoginStage.setScene(managerLoginWindow);
            managerLoginStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void showOperatorLoginPage() {
        DataHandler.getAllOperators();
        FXMLLoader operatorLoginLoader = new FXMLLoader(Main.class.getResource("OperatorLoginPage.fxml"));
        Scene operatorLoginWindow = null;
        try {
            operatorLoginWindow = new Scene(operatorLoginLoader.load(), 300, 200);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage operatorLoginStage = new Stage();
        operatorLoginStage.setTitle("Operator Login");
        operatorLoginStage.setScene(operatorLoginWindow);
        operatorLoginStage.show();
    }

    @FXML
    private void makeManagerAvatarFocused() {
        managerAvatar.setOpacity(1);
        adminLoginCaption.setOpacity(1);
    }

    @FXML
    private void makeOperatorAvatarFocused() {
        operatorAvatar.setOpacity(1);
        operatorLoginCaption.setOpacity(1);
    }

    @FXML
    private void makeManagerAvatarNotFocused() {
        managerAvatar.setOpacity(0.5);
        adminLoginCaption.setOpacity(0.3);
    }

    @FXML
    private void makeOperatorAvatarNotFocused() {
        operatorAvatar.setOpacity(0.5);
        operatorLoginCaption.setOpacity(0.3);
    }

}
