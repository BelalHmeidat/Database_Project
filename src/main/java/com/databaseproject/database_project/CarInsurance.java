package com.databaseproject.database_project;
import java.util.ArrayList;

import java.util.Date;

public class CarInsurance {

    private int insuranceID;

    private Date insuranceStartDate;

    private Date insuranceEndDate;

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

    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public Date getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(Date insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
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
