package com.databaseproject.database_project;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Car {

    private int carID;

    private String carModel;

    private int yearOfMan;

    private int carLiscenceID;

    private int carInsuranceID;

    private int carDriver1ID;

    private int carDriver2ID;

    private int carDriver3ID;

    public Car (int carID, String carModel, int yearOFMan, int carLiscenceID, int carInsuranceID) {
        this.carID = carID;
        this.carModel = carModel;
        this.yearOfMan = yearOFMan;
        this.carLiscenceID = carLiscenceID;
        this.carInsuranceID = carInsuranceID;
    }

    public static ArrayList<Car> cars = new ArrayList<>();

    public static ObservableList<Car> getCarsList(){
        ObservableList<Car> carList = FXCollections.observableArrayList();
        carList.addAll(cars);
        return carList;
    }

    public static Car getCar(int carID){
        for (Car car : cars){
            if (car.getCarID() == carID)
                return car;
        }
        return null;
    }
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYearOfMan() {
        return yearOfMan;
    }

    public void setYearOfMan(int yearOfMan) {
        this.yearOfMan = yearOfMan;
    }

    public int getCarLiscenceID() {
        return carLiscenceID;
    }

    public void setCarLiscenceID(int carLiscenceID) {
        this.carLiscenceID = carLiscenceID;
    }

    public int getCarInsuranceID() {
        return carInsuranceID;
    }

    public void setCarInsuranceID(int carInsuranceID) {
        this.carInsuranceID = carInsuranceID;
    }

    public int getCarDriver1ID() {
        return carDriver1ID;
    }

    public void setCarDriver1ID(int carDriver1ID) {
        this.carDriver1ID = carDriver1ID;
    }

    public int getCarDriver2ID() {
        return carDriver2ID;
    }

    public void setCarDriver2ID(int carDriver2ID) {
        this.carDriver2ID = carDriver2ID;
    }

    public int getCarDriver3ID() {
        return carDriver3ID;
    }

    public void setCarDriver3ID(int carDriver3ID) {
        this.carDriver3ID = carDriver3ID;
    }

    public Date getLicenseDate(){
        if (CarLicense.getLicense(carLiscenceID) == null)
            return null;
        return CarLicense.getLicense(carLiscenceID).getExpirationDate();
    }

    public Date getInsuranceDate(){
        if (CarInsurance.getInsurance(carInsuranceID) == null)
            return null;
        return CarInsurance.getInsurance(carInsuranceID).getInsuranceEndDate();
    }

    public SimpleIntegerProperty carIDProperty() {
        return new SimpleIntegerProperty(carID);
    }

    public SimpleIntegerProperty yearOfManProperty() {
        return new SimpleIntegerProperty(yearOfMan);
    }

    public SimpleDateFormat carLicenceDateProperty() {
        return new SimpleDateFormat(getLicenseDate().toString());
    }

    public SimpleDateFormat carInsuranceDateProperty() {
        return new SimpleDateFormat(getInsuranceDate().toString());
    }






}
