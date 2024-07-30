module space.test.calculator_ui {
    requires javafx.controls;
    requires javafx.fxml;


    opens space.dev.calculator_ui to javafx.fxml;
    exports space.dev.calculator_ui;
}