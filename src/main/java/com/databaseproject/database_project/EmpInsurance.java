package com.databaseproject.database_project;

import java.util.ArrayList;
import java.util.Date;

public class EmpInsurance {

    int insuranceID;
    float cost;

    Date expirationDate;

    Date renwalDate;

    public static ArrayList<EmpInsurance> empInsurances = new ArrayList<>();

    EmpInsurance(int insuranceID, float cost, Date expirationDate, Date renwalDate){
        this.insuranceID = insuranceID;
        this.cost = cost;
        this.expirationDate = expirationDate;
        this.renwalDate = renwalDate;
    }

    public static EmpInsurance getInsurance(int insuranceID){
        for(EmpInsurance empInsurance : empInsurances){
            if(empInsurance.getInsuranceID() == insuranceID){
                return empInsurance;
            }
        }
        return null;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getRenwalDate() {
        return renwalDate;
    }

    public void setRenwalDate(Date renwalDate) {
        this.renwalDate = renwalDate;
    }
}