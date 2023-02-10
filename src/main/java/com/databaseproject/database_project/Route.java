package com.databaseproject.database_project;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Route {

    public ArrayList<Driver> availableDrivers = new ArrayList<>();
    private String from;
    private String to;

    private int routeID;

    private float cost;

    private int duration;

    public Route( int routeID, String from, String to,float cost, int duration) {
        this.from = from;
        this.to = to;
        this.routeID = routeID;
        this.cost = cost;
        this.duration = duration;
    }

    public static ArrayList<Route> routes = new ArrayList<>();

    public static ObservableList<Route> getRoutesList(){
        ObservableList<Route> routeList = FXCollections.observableArrayList();
        routeList.addAll(routes);
        return routeList;
    }

    public static Route getRoute(String text) {
        DataHandler.getAllRoutes();
        String[] split = text.trim().split("-");
        for (Route route : routes) {
            if (route.getFrom().trim().equals(split[0].trim()) && route.getTo().trim().equals(split[1].trim())) {
                return route;
            }
        }
        return null;
    }

    public static Route getRoute(int routeID){
        for (Route route : routes){
            if (route.getRouteID() == routeID)
                return route;
        }
        return null;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public SimpleIntegerProperty routeIDProperty(){
        return new SimpleIntegerProperty(routeID);
    }

    public SimpleIntegerProperty durationProperty(){
        return new SimpleIntegerProperty(duration);
    }

    public SimpleFloatProperty costProperty(){
        return new SimpleFloatProperty(cost);
    }



}
