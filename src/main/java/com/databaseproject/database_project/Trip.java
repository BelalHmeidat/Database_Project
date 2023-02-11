package com.databaseproject.database_project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Trip {

    private int tripID;
    private int operatorID;
    private LocalDateTime departureTime;
    private LocalDateTime expectedArrivalTime;


    private int driverID;
    private int carID;
    private int routeID;

    private boolean isCancelled =false;
    private boolean isFinished = false;



    //Following attributes are for tableview filling only
//    private java.util.Date tripDate;

    SimpleStringProperty tripDate;
    SimpleStringProperty tripFrom;
    SimpleStringProperty tripTo;

    SimpleStringProperty tripBeginningTime;

    SimpleStringProperty tripEndTime;


//    public static void getTripsDate() {
//        for (Trip trip : trips){
//            trip.tripDate = Date.valueOf(trip.departureTime.toLocalDate());
//        }
//    }

//    public static void getTripFrom() {
//        for (Trip trips : trips){
//            trips.tripFrom = Route.getRoute(trips.routeID).getFrom();
//        }
//    }
//
//    public static void getTripTo() {
//        for (Trip trips : trips){
//            trips.tripTo = Route.getRoute(trips.routeID).getTo();
//        }
//    }
//
//    public static void getTripBeginningTime() {
//        for (Trip trips : trips){
//            trips.tripBeginningTime = trips.departureTime.toLocalTime();
//        }
//    }

//    public static void getTripEndTime() {
//        for (Trip trips : trips){
//            trips.tripEndTime = trips.expectedArrivalTime.toLocalTime();
//        }
//    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public String getStatus() {
        return status;
    }

    private int numOfPassengers;

    private String passangerPhone;
    private String passangerName;

    private String status;

    private String departureTimeStr;
    private String expectedArrivalTimeStr;
    private String actualArrivalTimeStr;


public Trip(int tripID, int operatorID, LocalDateTime departureTime, int driverID, int carID, int routeID, int numOfPassengers, String passangerPhone, String passangerName, LocalDateTime expectedArrivalTime) {
        this.tripID = tripID;
        this.operatorID = operatorID;
        this.departureTime = departureTime;
        this.driverID = driverID;
        this.carID = carID;
        this.routeID = routeID;
        this.numOfPassengers = numOfPassengers;
        this.passangerPhone = passangerPhone;
        this.passangerName = passangerName;
        this.isCancelled = false;
        this.isFinished = false;
        this.expectedArrivalTime = expectedArrivalTime;
        this.tripDate = new SimpleStringProperty(departureTime.toLocalDate().toString());
        this.tripBeginningTime = new SimpleStringProperty(departureTime.toLocalTime().toString());
        this.tripEndTime = new SimpleStringProperty(expectedArrivalTime.toLocalTime().toString());
        this.tripFrom = new SimpleStringProperty(Route.getRoute(routeID).getFrom());
        this.tripTo = new SimpleStringProperty(Route.getRoute(routeID).getTo());

    }

    public static ArrayList<Trip> trips = new ArrayList<>();


    public int getTripID() {
        return tripID;
    }

    public static Trip getTrip(int tripID){
        for(Trip trip: trips){
            if(trip.getTripID() == tripID){
                return trip;
            }
        }
        return null;
    }


    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public Date getDepartureDateSql(){
        return Date.valueOf(departureTime.toLocalDate());
    }

    public Time getDepartureTimeSql(){
        return Time.valueOf(departureTime.toLocalTime());
    }


    public Time getArrivalTimeSql(){
        return Time.valueOf(expectedArrivalTime.toLocalTime());
    }



    public String getDepartureTimeStr() {
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public String getExpectedArrivalTimeStr() {
        return expectedArrivalTimeStr;
    }

    public void setExpectedArrivalTimeStr(String expectedArrivalTimeStr) {
        this.expectedArrivalTimeStr = expectedArrivalTimeStr;
    }

    public String getActualArrivalTimeStr() {
        return actualArrivalTimeStr;
    }

    public void setActualArrivalTimeStr(String actualArrivalTimeStr) {
        this.actualArrivalTimeStr = actualArrivalTimeStr;
    }



    public void setExpectedArrivalTime(LocalDateTime arrivalTime) {
        this.expectedArrivalTime = arrivalTime;
    }


    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        driverID = driverID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int isNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public String getPassengerPhone() {
        return passangerPhone;
    }

    public void setPassengerPhone(String passangerPhone) {
        this.passangerPhone = passangerPhone;
    }

    public String getPassengerName() {
        return passangerName;
    }

    public void setPassengerName(String passangerName) {
        this.passangerName = passangerName;
    }

    public static ObservableList<Trip> getTripsList() {
        ObservableList<Trip> tripsList = FXCollections.observableArrayList();
        tripsList.addAll(trips);
        return tripsList;
    }

    public SimpleIntegerProperty getOperatorIDProperty() {
        return new SimpleIntegerProperty(this.operatorID);
    }

    public SimpleIntegerProperty getTripIDProperty() {
        return new SimpleIntegerProperty(this.tripID);
    }

    public SimpleIntegerProperty getDriverIDProperty() {
        return new SimpleIntegerProperty(this.driverID);
    }

    public SimpleIntegerProperty getCarIDProperty() {
        return new SimpleIntegerProperty(this.carID);
    }

    public SimpleIntegerProperty getRouteIDProperty() {
        return new SimpleIntegerProperty(this.routeID);
    }

//    public SimpleStringProperty tripDate() {
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
//        return new SimpleStringProperty(dateFormat.format(this.departureTime));
//    }

    public SimpleStringProperty getDepartureTimeProperty() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return new SimpleStringProperty(dateFormat.format(this.departureTime));
    }

    public SimpleStringProperty getArrivalTimeProperty() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return new SimpleStringProperty(dateFormat.format(this.expectedArrivalTime));
    }

    public SimpleIntegerProperty getNumOfPassengersProperty() {
        return new SimpleIntegerProperty(this.numOfPassengers);
    }

    public SimpleDateFormat getDOBProperty() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    public SimpleStringProperty getStatusProperty() {
        if (isCancelled){
            status = "Cancelled";
            return new SimpleStringProperty("Cancelled");
        }
        else {
            status = "Finished";
            return new SimpleStringProperty("Finished");
        }

    }
    @Override public String toString(){
        Route route = Route.getRoute(this.routeID);
        Driver driver = Driver.getDriver(this.driverID);
        return this.tripID + " " + driver.getName() + " " + route.getFrom() + " - " + route.getTo();
    }

    public void simulateDriverInput() { //simulates getting a cancellation signal from the driver (1/14 chance)
        Random random = new Random();
        int randomEvent = random.nextInt(14);
        if (randomEvent == 10) { //nothing against number 10
            this.isCancelled = true;
            this.status = "Cancelled :/";
        }
        else if (randomEvent == 13/*Lucky number*/){ // 1/13 chance say will arrive earlier than expected in a window of 20% of the trip duration
            float inTime = random.nextFloat(0, 0.2f) * Route.getRoute(this.routeID).getDuration();
            this.expectedArrivalTime = this.expectedArrivalTime.minusMinutes((long) inTime);
            this.status = "Arriving " + (int) inTime + " minutes early!";
        }
        else if (randomEvent > 9 /*but not 13 nor 10*/){ //say delays happen quite often. Trip gets delayed in a window of 10% of the trip duration but might happen more than once
            float delay = random.nextFloat(0, 0.1f) * Route.getRoute(this.routeID).getDuration();
            this.expectedArrivalTime = this.expectedArrivalTime.plusMinutes((long) delay);
            this.status = "Delayed by about " + (int) delay + " minutes";
        }
        else if(randomEvent > 13){
            this.status = "Passenger jumped out of the window!";

        }
        else this.status = "On time!";

    }
}
