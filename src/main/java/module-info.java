module org.example.dalaacademy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.dalaacademy to javafx.fxml;
    exports org.example.dalaacademy;
}