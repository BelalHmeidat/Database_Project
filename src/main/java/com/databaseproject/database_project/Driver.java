package com.databaseproject.database_project;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Date;

public class Driver {

    static ArrayList<Driver> drivers = new ArrayList<Driver>();
    static int driverCount = 0;
    String driverID;
    String name;
    String addressFirstLine;
    String addressSecondLine;
    String city;
    String zip;
    String phone;
    String email;
    String DOB;
    String workHours;
    boolean isAvailable; //available to take trips
    boolean isWorking; //working
    Date expectedAvailabilityTime;
    String location;

    Driver(String fullName, String addressFirstLine, String addressSecondLine, String city, String zip, String phone, String email, String DOB, String workHours, boolean isWorking, Date expectedAvailabilityTime, String location) {
        this.name = fullName;
        this.addressFirstLine = addressFirstLine;
        this.addressSecondLine = addressSecondLine;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.DOB = DOB;
        this.workHours = workHours;
        this.isWorking = isWorking;
        this.expectedAvailabilityTime = expectedAvailabilityTime;
        this.location = location;
        driverCount++;
        this.driverID = "D" + driverCount;
        drivers.add(this);
    }

    //method to sort drivers by availability
    public static void sortDriversByAvailability() {
        ArrayList<Driver> sortedDrivers = new ArrayList<Driver>();
        for (Driver driver : drivers) {
            if (driver.isAvailable && driver.isWorking) {
                sortedDrivers.add(driver);
            } else {
                sortedDrivers.add(0, driver);
            }
        }
        drivers = sortedDrivers;
    }

    public static void printDrivers() {
        for (Driver driver : drivers) {
            System.out.println(driver.name);
        }
    }

    public BooleanProperty isWorkingProperty(){
        return new SimpleBooleanProperty(isWorking);
    }

    public BooleanProperty isAvailableProperty(){
        return new SimpleBooleanProperty(isAvailable);
    }

    public StringProperty nameProperty(){
        return new SimpleStringProperty(name);
    }

    public StringProperty addressFirstLineProperty(){
        return new SimpleStringProperty(addressFirstLine);
    }

    public StringProperty addressSecondLineProperty(){
        return new SimpleStringProperty(addressSecondLine);
    }

    public StringProperty cityProperty(){
        return new SimpleStringProperty(city);
    }

    public StringProperty zipProperty(){
        return new SimpleStringProperty(zip);
    }

    public StringProperty phoneProperty(){
        return new SimpleStringProperty(phone);
    }

    public StringProperty emailProperty(){
        return new SimpleStringProperty(email);
    }

    public StringProperty DOBProperty(){
        return new SimpleStringProperty(DOB);
    }

    public StringProperty workHoursProperty(){
        return new SimpleStringProperty(workHours);
    }

    public StringProperty locationProperty(){
        return new SimpleStringProperty(location);
    }

    public StringProperty expectedAvailabilityTimeProperty(){
        return new SimpleStringProperty(expectedAvailabilityTime.toString());
    }

    public StringProperty driverIDProperty(){
        return new SimpleStringProperty(driverID);
    }



}