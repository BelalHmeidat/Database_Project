package com.databaseproject.database_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class NewTripController {

    public Stage getNewTripStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();

    }

    @FXML
    TextField passangerNameField;

    @FXML TextField passangerPhoneNumberField;

    @FXML
    Spinner<Integer> passangersNumberSpinner;
    @FXML
    MenuButton routeMenuButton;

    @FXML TextField tripCostField;

    @FXML MenuButton driverMenuButton;

    @FXML
    DatePicker tripDateField;

    @FXML TextField tripTimeField;
    @FXML
    Label estimatedTimeLabel;

    @FXML Button confirmTripButton;

    @FXML Label newTripError;
    @FXML public void confirmTripButtonClicked(){
        String passengerName = passangerNameField.getText().trim();
        if (passengerName.isEmpty() || passengerName.isBlank()) {
            newTripError.setText("Passenger name is required!");
            return;
        }
        String passangerPhoneNumber = passangerPhoneNumberField.getText();
        if (passangerPhoneNumber.isEmpty() || passangerPhoneNumber.isBlank()) {
            newTripError.setText("Passenger phone number is required!");
            return;
        }
        int passangersNumber = passangersNumberSpinner.getValue();
        String route = routeMenuButton.getText();
        float tripCost = 0;
        try {
            tripCost = Float.parseFloat(tripCostField.getText());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Trip cost must be a number");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tripDateStr = tripDateField.getValue().toString();
        LocalDate tripDate = null;
        try {
//            tripDate = dateFormat.parse(tripDateStr);
            tripDate = LocalDate.parse(tripDateField.getValue().toString().trim());
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
        }
        catch (NullPointerException e) {
            newTripError.setText("Trip date is required!");
            return;
        }
        if (tripTimeField.getText().trim().isEmpty()){
            newTripError.setText("Trip time is required!");
            return;
        }
        LocalTime tripTime = LocalTime.parse(tripTimeField.getText().trim());
        LocalDateTime tripDateTime = LocalDateTime.of(tripDate, tripTime);
        LocalTime estimatedEndTime = LocalTime.parse(estimatedTimeLabel.getText());
        LocalDate estimatedEndDate = LocalDate.parse(tripDateField.getValue().toString().trim()); //same as tripDate by default
        if (estimatedEndTime.isBefore(tripTime)){ //if time is before trip beginning time then trip will end next day
            estimatedEndDate = estimatedEndDate.plusDays(1);
        }
        LocalDateTime estimatedEndDateTime = LocalDateTime.of(estimatedEndDate, estimatedEndTime);
        int carID = -1;
        int driverID = -1;
        Driver tempDriver = null;
        try {
            tempDriver = Driver.getDriver(Integer.parseInt(driverMenuButton.getText().trim().split("-")[0].trim()));
            carID = tempDriver.getCarID();
            driverID = tempDriver.getDriverID();
        }catch (NumberFormatException e) {
            throw new RuntimeException("Driver ID must be a number");
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException("Check driver's car");
        }
        int routeID = -1;
        Route tempRoute = null;
        try {
            tempRoute = Route.getRoute(routeMenuButton.getText());
            routeID = tempRoute.getRouteID();
        }catch (NumberFormatException e) {
            throw new RuntimeException("Route ID must be a number");
        }
        catch (NullPointerException e) {
            throw new RuntimeException("Check route");
        }
        int operatorID = Operator.activeOperator.getOperatorID();


        tempDriver.setAvailable(false);
        Trip trip = new Trip(0, operatorID, tripDateTime, driverID, carID, routeID, passangersNumber, passangerPhoneNumber, passengerName, estimatedEndDateTime);
        DataHandler.addTrip(trip);
        DataHandler.updateDrivers();
        getNewTripStage().close();

    }

    @FXML public void initialize(){

        passangersNumberSpinner.setDisable(false);
        passangersNumberSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
        passangerPhoneNumberField.setDisable(false);
        routeMenuButton.setDisable(false);
        DataHandler.getAllRoutes();
        routeMenuButton.getItems().clear();
        for(Route route : Route.routes) {
            MenuItem routeMenuItem = new MenuItem(route.getFrom() + " - " + route.getTo());
            routeMenuItem.setOnAction(event -> {
                routeMenuButton.setText(routeMenuItem.getText());
                LocalTime time = LocalTime.parse(tripTimeField.getText());
                estimatedTimeLabel.setText(time.plusMinutes(route.getDuration()).toString());
                driverMenuButton.setDisable(false);
                tripCostField.setText(String.valueOf(route.getCost()));
                fetchAvailableDrivers(route);
            });
            routeMenuButton.getItems().add(routeMenuItem);
        }
//        tripCostField.setDisable(false);
        tripTimeField.setDisable(false);
        tripDateField.setDisable(false);
        tripDateField.setValue(java.time.LocalDate.now());
        DateFormat time = new SimpleDateFormat("HH:mm");
        tripTimeField.setText(time.format(java.util.Calendar.getInstance().getTime()));
    }

    private void fetchAvailableDrivers(Route route) {
        route.availableDrivers.clear();
        DataHandler.getAvailableDrivers(route);
        driverMenuButton.getItems().clear();
        if (route.availableDrivers.size() == 0){
            DataHandler.getAllAvailableDrivers();
            if (Driver.availableDrivers.size() == 0){
                newTripError.setText("No available drivers!");
                return;
            }
            for (Driver driver : Driver.availableDrivers){
                MenuItem driverMenuItem = new MenuItem(String.valueOf(driver.getDriverID()) + " - " + driver.getName());
                driverMenuItem.setOnAction(event -> {
                    driverMenuButton.setText(driverMenuItem.getText());
                    confirmTripButton.setDisable(false);
                });
                driverMenuButton.getItems().add(driverMenuItem);
            }
        }
        else {
            for (Driver driver : route.availableDrivers) {
                MenuItem driverMenuItem = new MenuItem(driver.getDriverID() + " - " + driver.getName());
                driverMenuItem.setOnAction(event -> {
                    driverMenuButton.setText(driverMenuItem.getText());
                    confirmTripButton.setDisable(false);
                });
                driverMenuButton.getItems().add(driverMenuItem);
            }
        }
    }

    @FXML public void updateEstimatedTime(){
        LocalTime time = LocalTime.parse(tripTimeField.getText());
        Route route = Route.getRoute(routeMenuButton.getText());
        assert route != null;
        estimatedTimeLabel.setText(time.plusMinutes(route.getDuration()).toString());
    }

    @FXML public void cancelButtonClicked(ActionEvent event){
        getNewTripStage(event).close();

    }

    private Stage getNewTripStage(){
        return (Stage) confirmTripButton.getScene().getWindow();
    }

}
