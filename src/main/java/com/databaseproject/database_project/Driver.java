package com.databaseproject.database_project;

import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Driver {

    public static Driver activeDriver = null;


    public static ArrayList<Driver> availableDrivers = new ArrayList<Driver>();
    static ArrayList<Driver> drivers = new ArrayList<Driver>();
    static int driverCount = 0;
    private int driverID;
    private String name;
    private String addressFirstLine;
    private String addressSecondLine;
    private String city;
    private String zip;
    private String phone;
    private String email;
    private LocalDate DOB;
    private String workHours;
    private boolean isAvailable; //available to take trips
    private boolean isWorking; //working
    private Date expectedAvailabilityTime;
    private String location;
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    private int carID;

    private int licenceID;



    private int insuranceID;
    java.sql.Date sqlDOB;


    Driver(int driverID, String fullName, String city, String phone, String email, LocalDate DOB, String workHours, boolean isWorking, boolean isAvailable, String location, int carID, int insuranceID, int  licenceID) {
        this.driverID = driverID;
        this.name = fullName;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.DOB = DOB;
        this.workHours = workHours;
        this.isWorking = isWorking;
        this.location = location;
        this.isAvailable = isAvailable;
        this.carID = carID;
        this.insuranceID = insuranceID;
        this.licenceID = licenceID;
        sqlDOB = java.sql.Date.valueOf(DOB);
        Car car = Car.getCar(carID);
        if (car.getCarDriver1() <= -1){
            car.setCarDriver1ID((driverID));
        } else if (car.getCarDriver2() <= -1){
            car.setCarDriver2ID(driverID);
        }
    }
    public int getLicenceID() {
        return licenceID;
    }

    public java.sql.Date getSqlDOB() {
        return sqlDOB;
    }

    public void setLicence(int licenceID) {
        this.licenceID = licenceID;
    }

    public int getInsurance() {
        return insuranceID;
    }

    public void setInsurance(int insuranceID) {
        this.insuranceID = insuranceID;
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

    public static ObservableList<Driver> getDriversList(){
        ObservableList<Driver> driverList = FXCollections.observableArrayList();
        driverList.addAll(drivers);
        return driverList;
    }

    public static void printDrivers() {
        for (Driver driver : drivers) {
            System.out.println(driver.name);
        }
    }

    public static Driver getDriver(int id) {
        DataHandler.getAllDrivers();
        for (Driver driver : drivers) {
            if (driver.driverID == id) {
                return driver;
            }
        }
        return null;
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

    public SimpleStringProperty DOBProperty(){
        DateFormat dobToString = new SimpleDateFormat("dd/MM/yyyy");
        return new SimpleStringProperty(dobToString.format(DOB));
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

    public IntegerProperty driverIDProperty(){
        return new SimpleIntegerProperty(driverID);
    }

    public static int getDriverCount() {
        return driverCount;
    }

    public static void setDriverCount(int driverCount) {
        Driver.driverCount = driverCount;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressFirstLine() {
        return addressFirstLine;
    }

    public void setAddressFirstLine(String addressFirstLine) {
        this.addressFirstLine = addressFirstLine;
    }

    public String getAddressSecondLine() {
        return addressSecondLine;
    }

    public void setAddressSecondLine(String addressSecondLine) {
        this.addressSecondLine = addressSecondLine;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public void setLicenceID(int licenceID) {
        this.licenceID = licenceID;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Date getExpectedAvailabilityTime() {
        return expectedAvailabilityTime;
    }

    public void setExpectedAvailabilityTime(Date expectedAvailabilityTime) {
        this.expectedAvailabilityTime = expectedAvailabilityTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCarID(){
        return this.carID;
    }


}