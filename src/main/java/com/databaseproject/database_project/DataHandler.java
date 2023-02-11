package com.databaseproject.database_project;

import java.sql.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    static Connection connection = null;
    public static void run() {

        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Taxi_office_db", "root", "P31Belbhmei");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }


    }


    public static void getAllOperators(){
        Operator.operators.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM operator");
            while (rs.next()) {
                int id = rs.getInt("operatorID");
                String name = rs.getString("operator_name");
                String phone = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String dob = rs.getString("DOB");
                String shiftType = rs.getString("shift_type");
                float salary = rs.getFloat("salary");
                Date dobToDate = Date.valueOf(dob);
                String password = rs.getString("operator_password");
                Operator operator = new Operator(id, name, phone, shiftType, address, email, dobToDate, salary, password);
                Operator.operators.add(operator);
                System.out.println(id + " " + name);
            }
        }catch (SQLException e){
//            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    public static void getAllDrivers(){
        Car.cars.clear();
        DataHandler.getAllCars();
        Driver.drivers.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM driver");
            while (rs.next()) {
                int id = rs.getInt("driverID");
                String name = rs.getString("driver_name");
                String phone = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date dob = rs.getDate("DOB");
                String shiftType = rs.getString("shift_type");
                String driver_location = rs.getString("driver_location");
                boolean isWorkingToday = false;
                if (rs.getInt("isWorkingToday") == 1)  isWorkingToday = true;
                boolean isAvailableToTakeTrips = false;
                if (rs.getInt("isAvailableToTakeTrips") == 1) isAvailableToTakeTrips = true;
                System.out.println(isAvailableToTakeTrips);
                int carID = rs.getInt("carID");
                int licenceID = rs.getInt("licenceID");
                int insuranceID = rs.getInt("insuranceID");

                Driver driver = new Driver(id, name, address, phone, email, dob, shiftType,isWorkingToday,isAvailableToTakeTrips, driver_location, Car.getCar(carID), EmpInsurance.getInsurance(insuranceID), DriverLicence.getLicense(licenceID));
                Driver.drivers.add(driver);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return;
        }
    }
    public static void getAllRoutes(){
        Route.routes.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Route");
            while (rs.next()) {
                int id = rs.getInt("pathID");
                String source_name = rs.getString("source_name");
                String destination_name = rs.getString("destination_name");
                float path_cost=rs.getFloat("path_cost");
                int duration= rs.getInt("expected_duration");
                Route path = new Route(id, source_name, destination_name, path_cost, duration);
                Route.routes.add(path);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return;
        }
    }
    public static void getAllCars() {
        Car.cars.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM car");
            while (rs.next()) {
                int id = rs.getInt("carID");
                String car_type = rs.getString("car_type");
                int yom  = rs.getInt("YOM");
                boolean car_active = rs.getBoolean("car_active");
                int licenseID = rs.getInt("licenceID");
                int insuranceID = rs.getInt("insuranceID");
                Car car  = new Car(id,car_type,yom, licenseID, insuranceID);
                Car.cars.add(car);
            }
        }catch (SQLException e){
            e.printStackTrace();
            return;
        }
    }

    public static void getAllCarsInsurances(){
        //TODO
    }

    public static void getAllEmpsInsurances(){
        EmpInsurance.empInsurances.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM empInsurance");
            while (rs.next()) {
                int id = rs.getInt("insuranceID");
                float insurance_cost = rs.getFloat("Cost");
                Date insurance_issue_date = rs.getDate("renewal_date");
                Date insurance_expiry_date = rs.getDate("expiration_date");
                EmpInsurance empInsurance = new EmpInsurance(id, insurance_cost, insurance_expiry_date, insurance_issue_date);
                EmpInsurance.empInsurances.add(empInsurance);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void getAllDriversLicenses(){
        DriverLicence.driverLicenses.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM driverLicence");
            while (rs.next()) {
                int id = rs.getInt("licenceID");
                Date licence_issue_date = rs.getDate("Expiration_date");
                Date licence_expiry_date = rs.getDate("Renewal_date");
                DriverLicence driverLicence = new DriverLicence(id, licence_expiry_date, licence_issue_date);
                DriverLicence.driverLicenses.add(driverLicence);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return;
        }



    }
    public static void getAllCarsLicenses(){
        //TODO
    }
    public static void getAllCarsRepairs(){
        //TODO
    }

    public static void getAllTrips(){
        Trip.trips.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM trip");
            while (rs.next()) {
                int id = rs.getInt("tripID");
                int driverID = rs.getInt("driverID");
                int carID = rs.getInt("carID");
                int operatorID = rs.getInt("operatorID");
                int routeID = rs.getInt("pathID");
                int numOfPassengers = rs.getInt("numOFpassenger");
                LocalDate tripDate = rs.getDate("tripDate").toLocalDate();
                LocalTime startTime = rs.getTime("begin_time").toLocalTime();
                LocalDateTime departureDateTime = LocalDateTime.of(tripDate, startTime);
                LocalTime endTime = rs.getTime("end_time").toLocalTime();
                LocalDate endDate= rs.getDate("tripDate").toLocalDate(); //same as trip date by default
                if (endTime.isBefore(startTime)) endDate = endDate.plusDays(1);// if trip end time is before the start time, trip must have ended in the next day
                LocalDateTime arrivalDateTime = LocalDateTime.of(endDate, endTime);
                String passangerName = rs.getString("passenger_name");
                String passangerPhone = rs.getString("passenger_phone");
                Trip trip = new Trip(id, operatorID, departureDateTime, driverID, carID, routeID, numOfPassengers, passangerPhone, passangerName, arrivalDateTime);
                Trip.trips.add(trip);
            }
        }catch (SQLException e){
//            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }


    public static ArrayList<Manager> getManagers(){
        ArrayList<Manager> managers = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT userName, managerPassword FROM ManagerCredentials");
            while (rs.next()) {
                String id = rs.getString("userName");
                String password = rs.getString("managerPassword");
                managers.add(new Manager(id, password));
            }
        }catch (SQLException e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        return managers;
    }


    public static void deleteOperator(Operator operator){
        try{
            Statement deleteOperator = connection.createStatement();
            deleteOperator.executeUpdate("DELETE FROM operator WHERE operatorID = " + operator.getOperatorID() + ";");
            Operator.operators.remove(operator);
        }catch (SQLException e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    public static void getAvailableDrivers(Route route) {
        route.availableDrivers.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT driverID, carID FROM driver WHERE driver.isAvailableToTakeTrips = true && driver.driver_location = '" + route.getFrom().trim() +"';");
            while (rs.next()) {
               int id = rs.getInt("driverID");
               int carID = rs.getInt("carID");
               route.availableDrivers.add(Driver.getDriver(id));
            }
        }catch (SQLException e){
            e.printStackTrace();
            return;
        }
    }

    public static void getAllAvailableDrivers() {
        Driver.availableDrivers.clear();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT driverID FROM driver WHERE driver.isAvailableToTakeTrips = true ;");
            while (rs.next()) {
                int id = rs.getInt("driverID");
                Driver.availableDrivers.add(Driver.getDriver(id));
            }
        }catch (SQLException e){
            e.printStackTrace();
            return;
        }
    }

    public static void addTrip(Trip trip) {
        int driverID = trip.getDriverID();
        int carID = trip.getCarID();
        int operatorID = trip.getOperatorID();
        int pathID = trip.getRouteID();
        int numOfPassengers = trip.getNumOfPassengers();
        Date tripDate  = trip.getDepartureDateSql();
        Time beginTime = trip.getDepartureTimeSql();
        Time endTime = trip.getArrivalTimeSql();
        String passengerName = trip.getPassengerName();
        String passengerPhone = trip.getPassengerPhone();
        int finished = 0;
        int canceled = 0;
        try {
            Statement addTrip = connection.createStatement();
            addTrip.executeUpdate("INSERT INTO trip (driverID, carID, operatorID, pathID, numOFpassenger, tripDate, begin_time, end_time, passenger_name, passenger_phone, isFinished, isCancelled) values (" + driverID + ", " + carID + ", " + operatorID + ", " + pathID + ", " + numOfPassengers + ", '" + tripDate.toString() + "', '" + beginTime.toString() + "', '" + endTime.toString() + "', '" + passengerName + "', '" + passengerPhone + "', '" + finished + "', '"+ canceled + "');");
            getAllTrips();
        }catch (SQLException e){
            e.printStackTrace();
            return;
        }
    }
    public static void addDriver(Driver driver) {
        String name = driver.getName();
        String phone = driver.getPhone();
        String email = driver.getEmail();
        String address = driver.getCity();
        Date dob = (Date) driver.getDOB();
        String shiftType = driver.getWorkHours();
        String driver_location = driver.getLocation();
        boolean isWorkingToday = driver.isWorking();
        int working = 0;
        if (isWorkingToday) working = 1;
        boolean isAvailableToTakeTrips = driver.isAvailable();
        int available = 0;
        if (isAvailableToTakeTrips) available = 1;
        int carID = driver.getCar().getCarID();
        int licenceID = driver.getLicence().getLicenseID();
        int insuranceID = driver.getInsurance().getInsuranceID();
        try {
            Statement addDriver = connection.createStatement();
            addDriver.executeUpdate("INSERT INTO driver (driver_name, phone_number, address, email, DOB, driver_location,shift_type, isWorkingToday,isAvailableToTakeTrips, carID, licenceID, insuranceID) values (" + name + "', '" + phone + "', '" + address + "', '" + email + "', '" + dob + "', '" + driver_location + "', '" + shiftType + "', '" + working + "'', '" + available + "', " + carID + ", " + licenceID +", " + insuranceID + ");");
            getAllDrivers();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    public static void updateDrivers() {
        for (Driver driver : Driver.drivers) {
            int id = driver.getDriverID();
            String name = driver.getName();
            String phone = driver.getPhone();
            String email = driver.getEmail();
            String address = driver.getCity();
            Date dob = (Date) driver.getDOB();
            String shiftType = driver.getWorkHours();
            String driver_location = driver.getLocation();
            boolean isWorkingToday = driver.isWorking();
            int working = 0;
            if (isWorkingToday) working = 1;
            boolean isAvailableToTakeTrips = driver.isAvailable();
            int available = 0;
            if (isAvailableToTakeTrips) available = 1;
            int carID = driver.getCar().getCarID();
            int licenceID = driver.getLicence().getLicenseID();
            int insuranceID = driver.getInsurance().getInsuranceID();
            try {
                Statement updateDriver = connection.createStatement();
                updateDriver.executeUpdate("UPDATE driver SET driver_name = '" + name + "', phone_number = '" + phone + "', address = '" + address + "', email = '" + email + "', DOB = '" + dob + "', driver_location = '" + driver_location + "', shift_type = '" + shiftType + "', isWorkingToday = '" + working + "', isAvailableToTakeTrips = '" + available + "', carID = " + carID + ", licenceID = " + licenceID + ", insuranceID = " + insuranceID + " WHERE driverID = " + id + ";");
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return;
            }
        }
    }

    public static void updateTrips() {
        for (Trip trip : Trip.trips) {
            int id = trip.getTripID();
            int driverID = trip.getDriverID();
            int carID = trip.getCarID();
            int operatorID = trip.getOperatorID();
            int pathID = trip.getRouteID();
            int numOfPassengers = trip.getNumOfPassengers();
            Date tripDate  = trip.getDepartureDateSql();
            Time beginTime = trip.getDepartureTimeSql();
            Time endTime = trip.getArrivalTimeSql();
            String passengerName = trip.getPassengerName();
            String passengerPhone = trip.getPassengerPhone();
            int finished = 0;
            if (trip.isFinished()) finished = 1;
            int canceled = 0;
            if (trip.isCancelled()) canceled = 1;
            try {
                Statement updateTrip = connection.createStatement();
                updateTrip.executeUpdate("UPDATE trip SET driverID = " + driverID + ", carID = " + carID + ", operatorID = " + operatorID + ", pathID = " + pathID + ", numOFpassenger = " + numOfPassengers + ", tripDate = '" + tripDate.toString() + "', begin_time = '" + beginTime.toString() + "', end_time = '" + endTime.toString() + "', passenger_name = '" + passengerName + "', passenger_phone = '" + passengerPhone + "', isFinished = '" + finished + "', isCancelled = '" + canceled + "' WHERE tripID = " + id + ";");
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return;
            }
        }
    }

//    public static void addOperator (Operator operator) {
//        String name =  addOperatorNameTextField.getText();
//        int id = operator.getOperatorID();
////        String name = operator.getOperatorName();
//        String phone =
//        String email = operator.getEmail();
//        String address = operator.getAddress();
//        Date dob = (Date) operator.getDOB();
//        String shiftType = operator.getShiftType();
//        float salary = operator.getSalary();
//
//        try {
//            Statement addOperator = connection.createStatement();
//            addOperator.executeUpdate("INSERT INTO operator (operator_name, phone_number, email, address, DOB, shift_type, salary) values (" + id + ", '" + name + "', '" + phone + "', '" + email + "', '" + address + "', '" + dob + "', '" + shiftType + "', " + salary + ");");
//
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return;
//        }
//    }

    public static boolean checkPhoneValidity(String phone){
        if (phone.length() != 11) return false;
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9') return false;
        }
        return true;

    }

    public static void addOperator(Operator operator) {
        //
    }
}
