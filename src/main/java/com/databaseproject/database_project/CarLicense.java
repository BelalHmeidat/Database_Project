package com.databaseproject.database_project;

import java.util.ArrayList;
import java.util.Date;

public class CarLicense {

    private int licenseID;
    private Date expirationDate;
    private Date renewalDate;

    public static ArrayList<CarLicense> carLicenses = new ArrayList<>();


    public CarLicense(int licenseID, Date expirationDate, Date renewalDate) {
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
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
