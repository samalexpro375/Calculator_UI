package space.test.calculator_ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    private String st_text = "";

    private ArrayList<Integer> numbers = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_0;

    @FXML
    private Button button_1;

    @FXML
    private Button button_2;

    @FXML
    private Button button_3;

    @FXML
    private Button button_4;

    @FXML
    private Button button_5;

    @FXML
    private Button button_6;

    @FXML
    private Button button_7;

    @FXML
    private Button button_8;

    @FXML
    private Button button_9;

    @FXML
    private Button button_clear;

    @FXML
    private Button button_div;

    @FXML
    private Button button_minus;

    @FXML
    private Button button_plus;

    @FXML
    private Button button_u;

    @FXML
    private TextField text;

    @FXML
    private Button button_r;

    @FXML
    void initialize() {
        button_0.setOnAction(event -> {
            st_text += "0";
            text.setText(st_text);
            System.out.println("0");
        });
        button_1.setOnAction(event -> {
            System.out.println("1");
            st_text += "1";
            text.setText(st_text);
        });
        button_2.setOnAction(event -> {
            System.out.println("2");
            st_text += "2";
            text.setText(st_text);
        });
        button_3.setOnAction(event -> {
            System.out.println("3");
            st_text += "3";
            text.setText(st_text);
        });
        button_4.setOnAction(event -> {
            System.out.println("4");
            st_text += "4";
            text.setText(st_text);
        });
        button_5.setOnAction(event -> {
            System.out.println("5");
            st_text += "5";
            text.setText(st_text);
        });
        button_6.setOnAction(event -> {
            System.out.println("6");
            st_text += "6";
            text.setText(st_text);
        });
        button_7.setOnAction(event -> {
            System.out.println("7");
            st_text += "7";
            text.setText(st_text);
        });
        button_8.setOnAction(event -> {
            System.out.println("8");
            st_text += "8";
            text.setText(st_text);
        });
        button_9.setOnAction(event -> {
            System.out.println("9");
            st_text += "9";
            text.setText(st_text);
        });
        button_plus.setOnAction(event -> {
            System.out.println("+");
            st_text += "+";
            text.setText(st_text);
        });
        button_minus.setOnAction(event -> {
            System.out.println("-");
            st_text += "-";
            text.setText(st_text);
        });
        button_u.setOnAction(event -> {
            System.out.println("*");
            st_text += "*";
            text.setText(st_text);
        });
        button_div.setOnAction(event -> {
            System.out.println("/");
            st_text += "/";
            text.setText(st_text);
        });
        button_clear.setOnAction(event -> {
            System.out.println("C");
            st_text = "";
            text.setText("0");
        });
        button_r.setOnAction(event -> {
            System.out.println("=");
        });
    }

}

