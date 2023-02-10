package com.databaseproject.database_project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class OperatorMainController {

    @FXML
    ListView<String> tripsList;

    @FXML Label tripIDLabel;

    @FXML Label tripPassengerPhoneNumberLabel;

    @FXML Label tripPassengersNumberLabel;



    @FXML Label tripDriverNameLabel;

    @FXML Label tripDriverPhoneNumberLabel;

    @FXML Label tripBeginTimeLabel;


    @FXML Label tripEndTimeLabel;

    @FXML Label tripStatusLabel;

    @FXML Label tripDateLabel;

    @FXML Label tripBeginCityLabel;

    @FXML
    Label tripEndCityLabel;

    @FXML Label tripRemainingTimeLabel;

    @FXML
    ProgressBar tripProgress;


    @FXML public void onMakeNewTripClick(){



        FXMLLoader newTripLoader = new FXMLLoader(Main.class.getResource("newTripWindow.fxml"));
        Scene newTripScene = null;
        try {
            newTripScene = new Scene(newTripLoader.load(), 500, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage newTripStage = new Stage();
        newTripStage.setTitle("New Trip");
        newTripStage.setScene(newTripScene);
        newTripStage.show();
    }
    @FXML public void closeOperatorMainStage (){
        Stage stage = (Stage) tripsList.getScene().getWindow();
        stage.close();
        Main.generalLoginStage.show();
    }

    @FXML public void updateTripList(){
        DataHandler.getAllTrips();
        DataHandler.getAllDrivers();
        DataHandler.getAllRoutes();
        DataHandler.getAllCars();
        DataHandler.getAllOperators();
        DataHandler.getAllEmpsInsurances();
        DataHandler.getAllDriversLicenses();
        DataHandler.getAllTrips();
        for (Trip trip : Trip.trips){
            LocalDateTime now = LocalDateTime.now();
            Driver driver = Driver.getDriver(trip.getDriverID());
            if (trip.getExpectedArrivalTime().isBefore(now)){ //if trip is finished
                driver.setAvailable(true);
                trip.setFinished(true);
                DataHandler.updateTrips();
            }
            else{ // if trip is not finished
                trip.simulateDriverInput();
                if (trip.isCancelled()) driver.setAvailable(true);
                else driver.setAvailable(false);
                DataHandler.updateTrips();
            }
            driver.setLocation(Route.getRoute(trip.getRouteID()).getTo());
            DataHandler.updateDrivers();

        }
        tripsList.getItems().clear();
        for (Trip trip : Trip.trips){
            tripsList.getItems().add(trip.toString());
        }
        tripsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue == null) return;
                int tripID = Integer.parseInt(newValue.split(" ")[0]);
                Trip trip = Trip.getTrip(tripID);
                tripIDLabel.setText(String.valueOf(trip.getTripID()));
                tripPassengerPhoneNumberLabel.setText(trip.getPassengerPhone());
                tripPassengersNumberLabel.setText(String.valueOf(trip.getNumOfPassengers()));
                tripDriverNameLabel.setText(Driver.getDriver(trip.getDriverID()).getName());
                tripDriverPhoneNumberLabel.setText(Driver.getDriver(trip.getDriverID()).getPhone());
                tripBeginTimeLabel.setText(trip.getDepartureTime().toLocalTime().toString());
                tripEndTimeLabel.setText(trip.getExpectedArrivalTime().toLocalTime().toString());
                tripStatusLabel.setText(trip.getStatus());
                tripDateLabel.setText(trip.getDepartureTime().toLocalDate().toString());
                tripBeginCityLabel.setText(Route.getRoute(trip.getRouteID()).getFrom());
                tripEndCityLabel.setText(Route.getRoute(trip.getRouteID()).getTo());
                if (trip.isFinished() || trip.isCancelled()){
                    tripRemainingTimeLabel.setText("00:00");
                    tripProgress.setProgress(1);
                    if (trip.isCancelled())
                        tripStatusLabel.setText("Cancelled");
                    else if (trip.isFinished())
                        tripStatusLabel.setText("Finished");
                }
                else {
                    tripRemainingTimeLabel.setText(String.valueOf(Duration.between(LocalDateTime.now(), trip.getExpectedArrivalTime()).toMinutes()) + " minutes");
                    tripProgress.setProgress(1 - (float) Duration.between(LocalDateTime.now(), trip.getExpectedArrivalTime()).toMinutes() / Duration.between(trip.getDepartureTime(), trip.getExpectedArrivalTime()).toMinutes());
                    tripStatusLabel.setText(trip.getStatus());
                }
            }
        });
    }





}
