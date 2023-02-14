package com.databaseproject.database_project;
import java.util.ArrayList;

import java.util.Date;

public class CarInsurance {

    private int insuranceID;

    private java.sql.Date insuranceStartDate;

    private java.sql.Date insuranceEndDate;

    private Float insuranceCost;



    public static ArrayList<CarInsurance> CarInsurances = new ArrayList<>();

    public CarInsurance(int insuranceID, Date insuranceStartDate, Date insuranceEndDate) {
        this.insuranceID = insuranceID;
        this.insuranceStartDate = insuranceStartDate;
        this.insuranceEndDate = insuranceEndDate;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public java.sql.Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(java.sql.Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public java.sql.Date getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(java.sql.Date insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    public float getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(float insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public static CarInsurance getInsurance(int insuranceID){
        for(CarInsurance carInsurance : CarInsurances){
            if(carInsurance.getInsuranceID() == insuranceID){
                return carInsurance;
            }
        }
        return null;
    }




}
