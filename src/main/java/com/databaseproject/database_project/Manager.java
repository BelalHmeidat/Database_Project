package com.databaseproject.database_project;

import java.util.ArrayList;

public class Manager {
    private String userName;

    private String password;

    static ArrayList<Manager> managers = new ArrayList<>();



    Manager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
