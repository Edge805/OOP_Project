module com.example.oop_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.junit.jupiter.api;
    requires junit;
    requires java.desktop;


    opens com.example.oop_project to javafx.fxml;
    exports com.example.oop_project;
}