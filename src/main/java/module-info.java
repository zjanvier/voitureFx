module com.example.voiturefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.voiturefx to javafx.fxml;
    exports com.example.voiturefx;
}