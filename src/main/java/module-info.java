module com.example.jigsaw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.jigsaw to javafx.fxml;
    exports com.example.jigsaw;
}