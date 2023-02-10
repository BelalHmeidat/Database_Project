package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.PasswordAuthentication;

//public class UIController {

//    @FXML
//    TableView driversTable;
//    @FXML
//    TableColumn driverIDColumn;
//
//    @FXML
//    TableColumn driverNameColumn;
//
//    @FXML
//    TableColumn driverPhoneColumn;
//
//    @FXML
//    TableColumn driverEmailColumn;
//
//    @FXML
//    TableColumn driverCityColumn;
//
//    @FXML
//    TableColumn driverWorkHoursColumn;
//
//    @FXML
//    TableColumn driverLocationColumn;
//
//    @FXML
//    TableColumn driverAvailabilityColumn;
//
//    @FXML
//    TableColumn driverExpectedAvailabilityTimeColumn;


//    void intilize() {
//        driverIDColumn.setCellValueFactory(new PropertyValueFactory<>("driverID"));
//        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        driverPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
//        driverCityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
//        driverEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//        driverWorkHoursColumn.setCellValueFactory(new PropertyValueFactory<>("workHours"));
//        driverLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
//        driverAvailabilityColumn.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
//        driverExpectedAvailabilityTimeColumn.setCellValueFactory(new PropertyValueFactory<>("expectedAvailabilityTime"));
//        for (Driver driver : Driver.drivers){
//            if (driver.isWorking) {
//                driversTable.getItems().add(driver);
//            }

//        }
//    }

//    static FXMLLoader operatorMainPage = new FXMLLoader(Main.class.getResource("mainOperatorPage.fxml"));
//    static FXMLLoader newTripLoader = new FXMLLoader(Main.class.getResource("newTripWindow.fxml"));
//    static FXMLLoader operatorLoginLoader = new FXMLLoader(Main.class.getResource("OperatorLoginPage.fxml"));
//    static FXMLLoader managerLoginLoader = new FXMLLoader(Main.class.getResource("AdminLoginPage.fxml"));

//    static Stage mainOperatorStage = new Stage();
//    static Stage operatorLoginStage = new Stage();
//    static Stage managerLoginStage = new Stage();
//    static Stage newTripStage = new Stage();

//    static {
//        Scene operatorWorkSpace = null;
//        try {
//            operatorWorkSpace = new Scene(operatorMainPage.load(), 900, 700);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        mainOperatorStage.setTitle("Operator Workspace");
//        mainOperatorStage.setScene(operatorWorkSpace);
//    }

//    static {
//        Scene operatorLoginWindow = null;
//        try {
//            operatorLoginWindow = new Scene(operatorLoginLoader.load(), 300, 200);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        operatorLoginStage.setTitle("Operator Login");
//        operatorLoginStage.setScene(operatorLoginWindow);
//    }

//    static {
//        Scene managerLoginWindow = null;
//        try {
//            managerLoginWindow = new Scene(managerLoginLoader.load(), 300, 200);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        managerLoginStage.setTitle("Manager Login");
//        managerLoginStage.setScene(managerLoginWindow);
//    }

//    static {
//
//        Scene newTripWindow = null;
//        try {
//            newTripWindow = new Scene(newTripLoader.load(), 500, 400);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        newTripStage.setTitle("New Trip");
//        newTripStage.setScene(newTripWindow);
//    }
//
//    @FXML
//    protected void onMakeNewTripClick() {
//        newTripStage.show();
//    }

//    @FXML
//    ImageView managerAvatar;
//    @FXML
//    ImageView operatorAvatar;
//    @FXML
//    Text adminLoginCaption;
//    @FXML
//    Text operatorLoginCaption;
//    @FXML
//    TextField operatorIDTextField;
//    @FXML
//    PasswordField operatorPasswordField;

//    @FXML
//    TextField managerIDTextField;

//    @FXML
//    PasswordField managerPasswordField;

//    @FXML
//    Label operatorLoginError;

//    @FXML
//    Label managerLoginError;


//    @FXML
//    private void makeManagerAvatarFocused() {
//        managerAvatar.setOpacity(1);
//        adminLoginCaption.setOpacity(1);
//    }
//
//    @FXML
//    private void makeOperatorAvatarFocused() {
//        operatorAvatar.setOpacity(1);
//        operatorLoginCaption.setOpacity(1);
//    }
//
//    @FXML
//    private void makeManagerAvatarNotFocused() {
//        managerAvatar.setOpacity(0.5);
//        adminLoginCaption.setOpacity(0.3);
//    }
//
//    @FXML
//    private void makeOperatorAvatarNotFocused() {
//        operatorAvatar.setOpacity(0.5);
//        operatorLoginCaption.setOpacity(0.3);
//    }

//    @FXML
//    private void showManagerLoginPage() {
//        Manager.managers = GetData.getManagers();
//        managerLoginStage.show();
//
//    }

//    @FXML
//    private void showOperatorLoginPage() {
//        GetData.getAllOperators();
//        operatorLoginStage.show();
//    }

//    @FXML
//    private void cancelManagerLogin() {
//        managerLoginStage.close();
//    }

//    @FXML
//    private void cancelOperatorLogin() {
//        operatorLoginStage.close();
//    }

//    @FXML
//    private void checkManagerLogin() {
//        String id = managerIDTextField.getText().trim();
//        if (id.length() > 20) {
//            managerLoginError.setText("ID is too long!");
//            return;
//        } else if (id.contains(" ")) {
//            managerLoginError.setText("ID can't contain spaces!");
//            return;
//        } else if (id.length() == 0) {
//            managerLoginError.setText("ID can't be empty!");
//            return;
//        }
//        String password = managerPasswordField.getText().trim();
//        if (password.length() > 20) {
//            managerLoginError.setText("Password is too long!");
//            return;
//        }
//        for (Manager manager : Manager.managers) {
//            if (id.equals(manager.getUserName())) {
//                if (password.equals(manager.getPassword())) {
//                    Main.generalLoginStage.close();
//                    managerLoginStage.close();
////                    ManagerMainController.mainManagerStage.show();
////                        ManagerMainController.fillManagerWorkSpace();
//                    ManagerMainController managerMainController = managerLoginLoader.getController();
//                    managerMainController.intialize();
//                    return;
//                }
//            }
//        }
//        managerLoginError.setText("Wrong ID or Password!");
//    }


//    @FXML
//    private void checkOperatorLogin() {
//        int operatorID = -1;
//        String id = operatorIDTextField.getText().trim();
//        if (id.length() != 3) {
//            operatorLoginError.setText("ID has to be 3 digits!");
//            return;
//        }
//        try {
//            operatorID = Integer.parseInt(id);
//            if (operatorID < 0) {
//                operatorLoginError.setText("ID has to be positive!");
//                return;
//            }
//        } catch (NumberFormatException e) {
//            operatorLoginError.setText("ID has to be digits only!");
//            return;
//        }
//        String password = operatorPasswordField.getText().trim();
//        if (password.length() > 20) {
//            operatorLoginError.setText("Password is too long!");
//            return;
//        }
//        for (Operator operator : Operator.operators) {
//            if (operatorID == operator.getOperatorID()) {
//                if (password.equals(operator.getOperatorPassword())) {
//                    operatorLoginStage.close();
//                    mainOperatorStage.show();
//                    return;
//                }
//            }
//        }
//        operatorLoginError.setText("Wrong ID or Password!");
//    }
//}


