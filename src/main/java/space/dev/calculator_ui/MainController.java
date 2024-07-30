package space.dev.calculator_ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Stack;

public class MainController {

    @FXML
    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9,
            button_clear, button_div, button_minus, button_plus, button_multiply, button_equals, right_bracket,
            left_bracket, backspace;

    @FXML
    private TextField output;

    private final StringBuilder currentExpression = new StringBuilder();

    @FXML
    void initialize() {
        Button[] numberButtons = {button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7,
                button_8, button_9};
        for (Button button : numberButtons) {
            button.setOnAction(e -> {
                currentExpression.append(button.getText());
                updateOutput();
            });
        }

        button_plus.setOnAction(e -> addOperator("+"));
        button_minus.setOnAction(e -> addOperator("-"));
        button_multiply.setOnAction(e -> addOperator("*"));
        button_div.setOnAction(e -> addOperator("/"));
        left_bracket.setOnAction(e -> addOperator("("));
        right_bracket.setOnAction(e -> addOperator(")"));

        button_clear.setOnAction(e -> {
            currentExpression.setLength(0);
            updateOutput();
        });

        backspace.setOnAction(e -> {
            int length = currentExpression.length();
            if (length > 0) {
                if (length >= 3 && currentExpression.charAt(length - 1) == ' ' && currentExpression.charAt(length - 2)
                        != ' ' && currentExpression.charAt(length - 3) == ' ') {
                    currentExpression.delete(length - 3, length);
                } else {
                    currentExpression.deleteCharAt(length - 1);
                }
                updateOutput();
            }
        });

        button_equals.setOnAction(e -> {
            String result = evaluateExpression(currentExpression.toString());
            currentExpression.setLength(0);
            currentExpression.append(result);
            updateOutput(true);
        });

        output.setText(currentExpression.toString());
        output.positionCaret(currentExpression.length());
    }

    private void addOperator(String operator) {
        currentExpression.append(" ").append(operator).append(" ");
        updateOutput();
    }

    private void updateOutput() {
        updateOutput(false);
    }

    private void updateOutput(boolean moveToStart) {

        String outputText = currentExpression.toString().replace(" ", "");
        output.setText(outputText);

        if (moveToStart) {
            output.positionCaret(0);
        } else {
            output.positionCaret(currentExpression.length());
        }
    }

    private String evaluateExpression(String expression) {
        try {
            double result = evaluatePostfix(convertToPostfix(expression));
            return formatResult(result);
        } catch (Exception e) {
            return "Error";
        }
    }

    private String convertToPostfix(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        String[] tokens = infix.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                postfix.append(token).append(" ");
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && !stack.peek().equals("(") && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> -1;
        };
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.format("%s", result);
        }
    }
}