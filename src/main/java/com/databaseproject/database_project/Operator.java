package com.databaseproject.database_project;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Operator {
    private int operatorID;
    private String operatorPassword;
    private String operatorName;

    private String operatorPhone;

    private String operatorShift;

    private String operatorAddress;

    private String operatorEmail;

    private Date operatorDOB;
    private float operatorSalary;

    public static ArrayList<Operator> operators = new ArrayList<>();

    Operator(int operatorID, String operatorName, String operatorPhone, String operatorShift, String operatorAddress, String operatorEmail, Date operatorDOB, float operatorSalary, String password) {
        this.operatorID = operatorID;
        this.operatorName = operatorName;
        this.operatorPhone = operatorPhone;
        this.operatorShift = operatorShift;
        this.operatorAddress = operatorAddress;
        this.operatorEmail = operatorEmail;
        this.operatorDOB = operatorDOB;
        this.operatorSalary = operatorSalary;
        this.operatorPassword = password;
    }

    public static Operator activeOperator = null;

    public int getOperatorID() {
        return operatorID;
    }

    public String getOperatorPassword() {
        return operatorPassword;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    public void setOperatorPassword(String operatorPassword) {
        this.operatorPassword = operatorPassword;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getOperatorShift() {
        return operatorShift;
    }

    public void setOperatorShift(String operatorShift) {
        this.operatorShift = operatorShift;
    }

    public String getOperatorAddress() {
        return operatorAddress;
    }

    public void setOperatorAddress(String operatorAddress) {
        this.operatorAddress = operatorAddress;
    }

    public String getOperatorEmail() {
        return operatorEmail;
    }

    public void setOperatorEmail(String operatorEmail) {
        this.operatorEmail = operatorEmail;
    }

    public Date getOperatorDOB() {
        return operatorDOB;
    }

    public void setOperatorDOB(Date operatorDOB) {
        this.operatorDOB = operatorDOB;
    }

    public float getOperatorSalary() {
        return operatorSalary;
    }

    public void setOperatorSalary(float operatorSalary) {
        this.operatorSalary = operatorSalary;
    }

    public static ObservableList<Operator> getOperatorsList() {
        ObservableList<Operator> operatorsList = FXCollections.observableArrayList();
        operatorsList.addAll(operators);
        return operatorsList;
    }

    public SimpleIntegerProperty getOperatorIDProperty() {
        return new SimpleIntegerProperty(this.operatorID);
    }

    public SimpleDateFormat getDOBProperty() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    public SimpleFloatProperty getSalaryProperty() {
        return new SimpleFloatProperty(this.operatorSalary);
    }
}

