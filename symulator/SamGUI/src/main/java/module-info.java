module com.example.samgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.samgui to javafx.fxml;
    exports com.example.samgui;
}