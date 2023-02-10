module com.databaseproject.database_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.databaseproject.database_project to javafx.fxml;
    exports com.databaseproject.database_project;
}