module space.test.calculator_ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens space.test.calculator_ui to javafx.fxml;
    exports space.test.calculator_ui;
}