package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class ManagerMainController {


    @FXML
    Tab tripsTab;
    @FXML Tab operatorsTab;

    @FXML Tab driversTab;
    @FXML Tab carsTab;
    @FXML Tab routesTab;

    @FXML
    TableView<Operator> operatorsTable;
    @FXML
    TableColumn<Operator, Integer> operatorIDColumn;

    @FXML TableColumn<Operator, String> operatorNameColumn;

    @FXML TableColumn<Operator, String> operatorPhoneColumn;

    @FXML TableColumn<Operator, String> operatorShiftColumn;
    @FXML TableColumn<Operator, String> operatorAddressColumn;

    @FXML TableColumn<Operator, String> operatorEmailColumn;

    @FXML TableColumn<Operator, Date> operatorDOBColumn;

    @FXML TableColumn<Operator, Float> operatorSalaryColumn;

    @FXML TableColumn<Operator, String> operatorPasswordColumn;
    @FXML TableView <Route> routesTable;
    @FXML TableColumn<Route,Integer>RoutesIDColumn;
    @FXML TableColumn<Route,String>RoutesFromColumn;
    @FXML TableColumn<Route,String>RoutesToColumn;
    @FXML TableColumn<Route,Float>RoutesCostColumn;
    @FXML TableColumn<Route,Integer>RoutesEstimatedColumn;

    @FXML TableColumn<Car,Integer>CarIDColumn;
    @FXML TableColumn<Car,String>CarModelColumn;
    @FXML TableColumn<Car,Date>CarDateOfPurrchaseColumn;
    @FXML TableColumn<Car,Date>CarLicencseExpirationColumn;
    @FXML TableColumn<Car,Date>CarInsuranceExpirationColumn;
    @FXML TableColumn<Car,Integer>CarDriver1Column;
    @FXML TableColumn<Car,Integer>CarDriver2Column;
    @FXML TableColumn<Car,Integer>CarDriver3Column;

    @FXML TableView<Car> CarsTable;

    @FXML public void fillCarsInManager() {
        CarsTable.getItems().clear();
        DataHandler.getAllCars();
        CarIDColumn.setCellValueFactory(new PropertyValueFactory<>("CarID"));
        CarModelColumn.setCellValueFactory(new PropertyValueFactory<>("CarModel"));
        CarDateOfPurrchaseColumn.setCellValueFactory(new PropertyValueFactory<>("CarDateOfPurrchase"));
        CarLicencseExpirationColumn.setCellValueFactory(new PropertyValueFactory<>("CarLicencseExpiration"));
        CarInsuranceExpirationColumn.setCellValueFactory(new PropertyValueFactory<>("CarInsuranceExpiration"));
        CarDriver1Column.setCellValueFactory(new PropertyValueFactory<>("CarDriver1"));
        CarDriver2Column.setCellValueFactory(new PropertyValueFactory<>("CarDriver2"));
        CarDriver3Column.setCellValueFactory(new PropertyValueFactory<>("CarDriver3"));



        CarsTable.setItems(Car.getCarsList());
    }


        public Stage getManagerMainStage(){
        return (Stage) operatorsTable.getScene().getWindow();
    }

    @FXML public void fillManagerMain(){
        if (operatorsTab.isSelected()){
            fillOperatorsInManager();
        }
    }

    @FXML public void fillTripsInManager(){
//        tripsTable.getItems().clear();
//        GetData.getAllTrips();
//        tripIDColumn.setCellValueFactory(new PropertyValueFactory<>("tripID"));
//        tripsTable.setItems(Trip.getTripsList());

    }

    @FXML public void fillOperatorsInManager() {
        operatorsTable.getItems().clear();
        DataHandler.getAllOperators();
        operatorIDColumn.setCellValueFactory(new PropertyValueFactory<>("operatorID"));
        operatorNameColumn.setCellValueFactory(new PropertyValueFactory<>("operatorName"));
        operatorPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("operatorPhone"));
        operatorShiftColumn.setCellValueFactory(new PropertyValueFactory<>("operatorShift"));
        operatorAddressColumn.setCellValueFactory(new PropertyValueFactory<>("operatorAddress"));
        operatorEmailColumn.setCellValueFactory(new PropertyValueFactory<>("operatorEmail"));
        operatorDOBColumn.setCellValueFactory(new PropertyValueFactory<>("operatorDOB"));
        operatorSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("operatorSalary"));
        operatorPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("operatorPassword"));

        operatorsTable.setItems(Operator.getOperatorsList());

    }
    @FXML public void fillDriversInManager(){
        //TODO
    }

    @FXML public void fillRoutesInManager(){

        routesTable.getItems().clear();
        DataHandler.getAllRoutes();
        RoutesIDColumn.setCellValueFactory(new PropertyValueFactory<>("RoutesID"));
        RoutesFromColumn.setCellValueFactory(new PropertyValueFactory<>("RoutesFrom"));
        RoutesToColumn.setCellValueFactory(new PropertyValueFactory<>("RoutesTo"));
        RoutesCostColumn.setCellValueFactory(new PropertyValueFactory<>("RoutesCost"));
        RoutesEstimatedColumn.setCellValueFactory(new PropertyValueFactory<>("RoutesEstimated"));
        routesTable.setItems(Route.getRoutesList());
    }
    @FXML public void addManagerClicked(){
        //TODO
    }

    @FXML public void editManagerClicked(){
        //TODO
    }

    @FXML public void managerLogoffButtonClicked(){
        getManagerMainStage().close();
        Main.generalLoginStage.show();
    }

    @FXML public void managerAddButtonClicked(){}
    @FXML public void managerEditButtonClicked(){}


    @FXML public void driverAddButtonClicked(){
        FXMLLoader addDriverLoader = new FXMLLoader(getClass().getResource("AddDriverPage.fxml"));
        Stage addDriverStage = new Stage();
        addDriverStage.setTitle("Add Driver");
        try {
            addDriverStage.setScene(new Scene(addDriverLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addDriverStage.show();

//        String name = addDriverNameField.getText();
//        String phone = addDriverPhoneField.getText();
//        String address = addDriverAddressField.getText();
//        String email = addDriverEmailField.getText();
//        String dob = addDriverDOBField.getText();
//
//        addDriver(name, phone, address, email, dob);
    }

    @FXML public void driverEditButtonClicked(){
        //TODO
    }

    @FXML public void driverRemoveButtonClicked(){
        //TODO
    }

    @FXML public void carAddButtonClicked(){
        //TODO
    }

    @FXML public void carEditButtonClicked(){
        //TODO
    }

    @FXML public void carRemoveButtonClicked(){
        //TODO
    }

    @FXML public void routeAddButtonClicked(){
        //TODO
    }

    @FXML public void routeEditButtonClicked(){
        //TODO
    }

    @FXML public void routeRemoveButtonClicked(){
        //TODO
    }
    @FXML public void operatorAddButtonClicked(){
        //TODO
    }

    @FXML public void operatorEditButtonClicked(){
        //TODO
    }

    @FXML public void operatorRemoveButtonClicked(){
        //TODO
    }






}

