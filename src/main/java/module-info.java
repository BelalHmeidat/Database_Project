module com.databaseproject.database_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.databaseproject.database_project to javafx.fxml;
    exports com.databaseproject.database_project;
}