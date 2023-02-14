package com.databaseproject.database_project;

import java.util.ArrayList;
import java.util.Date;

public class CarLicense {

    private int licenseID;
    private java.sql.Date expirationDate;
    private java.sql.Date renewalDate;

    public static ArrayList<CarLicense> carLicenses = new ArrayList<>();


    public CarLicense(int licenseID, java.sql.Date expirationDate, java.sql.Date renewalDate) {
        this.licenseID = licenseID;
        this.expirationDate = expirationDate;
        this.renewalDate = renewalDate;
    }

    public int getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }

    public java.sql.Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(java.sql.Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public java.sql.Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(java.sql.Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public static CarLicense getLicense(int licenseID){
        for(CarLicense license : carLicenses){
            if(license.getLicenseID() == licenseID){
                return license;
            }
        }
        return null;
    }

}
