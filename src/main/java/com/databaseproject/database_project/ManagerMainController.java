package com.databaseproject.database_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class ManagerMainController implements Initializable {


    @FXML
    private Tab tripsTab;
    @FXML private Tab operatorsTab;

    @FXML private Tab driversTab;
    @FXML private Tab carsTab;
    @FXML private Tab routesTab;

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

    @FXML TableView<Driver> driversTable;
    @FXML TableColumn<Driver, Integer> driverIDColumn;

    @FXML TableColumn<Driver, String> driverNameColumn;

    @FXML TableColumn<Driver, String> driverPhoneColumn;

    @FXML TableColumn<Driver, String> driverAddressColumn;

    @FXML TableColumn<Driver, String> driverEmailColumn;

    @FXML TableColumn<Driver, java.sql.Date> driverDOBColumn;
    @FXML TableColumn<Driver, String> driverShiftColumn;

    @FXML TableColumn<Car,Integer>CarIDColumn;
    @FXML TableColumn<Car,String>CarModelColumn;
    @FXML TableColumn<Car,Integer>CarDateOfPurrchaseColumn;
    @FXML TableColumn<Car, java.sql.Date>CarLicencseExpirationColumn;
    @FXML TableColumn<Car,java.sql.Date>CarInsuranceExpirationColumn;
    @FXML TableColumn<Car,Integer>CarDriver1Column;
    @FXML TableColumn<Car,Integer>CarDriver2Column;

    @FXML TableView<Car> CarsTable;
    @FXML TableView<Trip> tripsTable;

//    @FXML TableColumn<Trip, Integer> tripIDColumn;


    @FXML TableColumn<Trip,Integer>tripDriverIDColumn;
    @FXML TableColumn<Trip,Integer>tripopretorIDColumn;
    @FXML TableColumn<Trip,Integer>tripcarIDColumn;
    @FXML TableColumn<Trip ,String>tripFromColumn;
    @FXML TableColumn<Trip,String>tripToColumn;
    @FXML TableColumn<Trip, String>tripDateColumn;
    @FXML TableColumn<Trip, String>tripBeginningTimeColumn;
    @FXML TableColumn<Trip,String>tripEndTimeColumn;
    @FXML TableColumn<Trip,String>tripStatusColumn;

    @FXML public void fillTripsInManager() {
        tripsTable.getItems().clear();
        DataHandler.getAllRoutes();
        DataHandler.getAllTrips();
        DataHandler.getAllDrivers();
        DataHandler.getAllCars();
        DataHandler.getAllOperators();

        tripDriverIDColumn.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        tripopretorIDColumn.setCellValueFactory(new PropertyValueFactory<>("operatorID"));
        tripcarIDColumn.setCellValueFactory(new PropertyValueFactory<>("carID"));
        tripFromColumn.setCellValueFactory(new PropertyValueFactory<>("tripFrom"));
        tripToColumn.setCellValueFactory(new PropertyValueFactory<>("tripTo"));
        tripDateColumn.setCellValueFactory(new PropertyValueFactory<>("tripDate"));
        tripBeginningTimeColumn.setCellValueFactory(new PropertyValueFactory<>("tripBeginningTime"));
        tripEndTimeColumn.setCellValueFactory(new PropertyValueFactory<>("tripEndTime"));
        tripStatusColumn.setCellValueFactory(new PropertyValueFactory<>("tripManagerStatus"));


        tripsTable.setItems(Trip.getTripsList());
    }

    @FXML public void fillCarsInManager() {
        CarsTable.getItems().clear();
        DataHandler.getAllCars();
        DataHandler.getAllDrivers();
        DataHandler.getAllCarsLicenses();
        DataHandler.getAllCarsInsurances();
        CarIDColumn.setCellValueFactory(new PropertyValueFactory<>("CarID"));
        CarModelColumn.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        CarDateOfPurrchaseColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfMan"));
        CarLicencseExpirationColumn.setCellValueFactory(new PropertyValueFactory<>("carLicenceExpiration"));
        CarInsuranceExpirationColumn.setCellValueFactory(new PropertyValueFactory<>("carInsuranceExpiration"));
        CarDriver1Column.setCellValueFactory(new PropertyValueFactory<>("carDriver1"));
        CarDriver2Column.setCellValueFactory(new PropertyValueFactory<>("carDriver2"));



        CarsTable.setItems(Car.getCarsList());
    }


    public Stage getManagerMainStage(){
        return (Stage) operatorsTable.getScene().getWindow();
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
        driversTable.getItems().clear();
        DataHandler.getAllDrivers();
        driverIDColumn.setCellValueFactory(new PropertyValueFactory<>("driverID"));
        driverNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        driverPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        driverAddressColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        driverEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        driverDOBColumn.setCellValueFactory(new PropertyValueFactory<>("sqlDOB"));
        driverShiftColumn.setCellValueFactory(new PropertyValueFactory<>("workHours"));

        driversTable.setItems(Driver.getDriversList());
    }

    @FXML public void fillRoutesInManager(){

        routesTable.getItems().clear();
        DataHandler.getAllRoutes();
        RoutesIDColumn.setCellValueFactory(new PropertyValueFactory<>("routeID"));
        RoutesFromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));
        RoutesToColumn.setCellValueFactory(new PropertyValueFactory<>("to"));
        RoutesCostColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        RoutesEstimatedColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
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
        Driver driver = driversTable.getSelectionModel().getSelectedItem();
        Driver.activeDriver = driver;
        FXMLLoader editDriverLoader = new FXMLLoader(getClass().getResource("EditDriverPage.fxml"));
        Stage editDriverStage = new Stage();
        editDriverStage.setTitle("Edit Driver");
        try {
            editDriverStage.setScene(new Scene(editDriverLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editDriverStage.show();
        System.out.println(driver.getName());
    }

//    @FXML public void driverRemoveButtonClicked(){
//        Driver driver = driversTable.getSelectionModel().getSelectedItem();
//        DataHandler.deleteDriver(driver);
//        fillDriversInManager();
//    }

    @FXML public void carAddButtonClicked(){
        Car car = CarsTable.getSelectionModel().getSelectedItem();
        FXMLLoader addCarLoader = new FXMLLoader(getClass().getResource("AddCarPage.fxml"));
        Stage addCarStage = new Stage();
        addCarStage.setTitle("Add Car");
        try {
            addCarStage.setScene(new Scene(addCarLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addCarStage.show();
    }

    @FXML public void carEditButtonClicked(){
        //TODO get selected Object from observable list
        Car car = CarsTable.getSelectionModel().getSelectedItem();

        FXMLLoader editCarLoader = new FXMLLoader(getClass().getResource("editCarPage.fxml"));
        Stage editCarStage = new Stage();
        editCarStage.setTitle("Edit Car");
        try {
            editCarStage.setScene(new Scene(editCarLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editCarStage.show();
    }

//    @FXML public void carRemoveButtonClicked(){
//        //TODO get selected Object from observable list
//        Car car = CarsTable.getSelectionModel().getSelectedItem();
//
//    }

    @FXML public void routeAddButtonClicked(){
        //TODO get selected Object from observable list
        Route route = routesTable.getSelectionModel().getSelectedItem();

        FXMLLoader addRouteLoader = new FXMLLoader(getClass().getResource("AddRoutePage.fxml"));
        Stage addRouteStage = new Stage();
        addRouteStage.setTitle("Add Route");
        try {
            addRouteStage.setScene(new Scene(addRouteLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addRouteStage.show();
    }

    @FXML public void routeEditButtonClicked(){
        //TODO get selected Object from observable list
        Route route = routesTable.getSelectionModel().getSelectedItem();
        FXMLLoader editRouteLoader = new FXMLLoader(getClass().getResource("EditPath.fxml"));
        Stage editRouteStage = new Stage();
        editRouteStage.setTitle("Edit Route");
        try {
            editRouteStage.setScene(new Scene(editRouteLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editRouteStage.show();
    }

//    @FXML public void routeRemoveButtonClicked(){
//        //TODO get selected Object from observable list
//        Route route = routesTable.getSelectionModel().getSelectedItem();
//
//    }
    @FXML public void operatorAddButtonClicked(){
        FXMLLoader addOperatorPage = new FXMLLoader(getClass().getResource("AddOperatorPage.fxml"));
        Scene addOperatorScene = null;
        try {
            addOperatorScene = new Scene(addOperatorPage.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage newTripStage = new Stage();
        newTripStage.setTitle("Add Operator");
        newTripStage.setScene(addOperatorScene);
        newTripStage.show();
    }

    @FXML public void operatorEditButtonClicked(){
        //TODO get selected Object from observable list
        Operator operator = operatorsTable.getSelectionModel().getSelectedItem();
        FXMLLoader editOperatorLoader = new FXMLLoader(getClass().getResource("EditOperator.fxml"));
        Stage editOperatorStage = new Stage();
        editOperatorStage.setTitle("Edit Operator");
        try {
            editOperatorStage.setScene(new Scene(editOperatorLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editOperatorStage.show();
    }

//    @FXML public void operatorRemoveButtonClicked(){
//        //TODO get selected Object from observable list
//        Operator operator = operatorsTable.getSelectionModel().getSelectedItem();
//
//
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillTables();

    }

    public void fillTables(){
        fillTripsInManager();
        fillOperatorsInManager();
        fillDriversInManager();
        fillRoutesInManager();
        fillCarsInManager();
    }

    @FXML public void changDriverCarButtonClicked(){
        Driver driver = driversTable.getSelectionModel().getSelectedItem();
        //TODO get selected Object from observable list
        FXMLLoader changeCarLoader = new FXMLLoader(getClass().getResource("changeCarPage.fxml"));
        Stage changeCarStage = new Stage();
        changeCarStage.setTitle("Change Driver Car");
        try {
            changeCarStage.setScene(new Scene(changeCarLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        changeCarStage.show();

    }


}

