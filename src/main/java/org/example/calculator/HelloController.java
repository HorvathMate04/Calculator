package org.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField number1;

    @FXML
    private TextField number2;

    @FXML
    private Label resultLabel;

    @FXML
    private void handleAddition() {
        calculate("+");
    }

    @FXML
    private void handleMinus() {
        calculate("-");
    }

    @FXML
    private void handleMultiplication() {
        calculate("*");
    }

    @FXML
    private void handleDivision() {
        calculate("/");
    }

    @FXML
    private void handlePrecent() {
        calculate("%");
    }

    private void calculate(String operation) {
        try {
            double num1 = Double.parseDouble(number1.getText());
            double num2 = Double.parseDouble(number2.getText());
            double result;

            switch (operation) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        throw new ArithmeticException("Nullával való osztás!");
                    }
                    result = Math.round((num1 / num2) * 100.0) / 100.0;
                }
                case "%" -> result = num1 % num2;
                default -> throw new IllegalArgumentException("Ismeretlen művelet!");
            }

            resultLabel.setText("Eredmény: " + result);

        } catch (NumberFormatException e) {
            showError("Kérlek, érvényes számokat adj meg!");
        } catch (ArithmeticException e) {
            showError(e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Hiba");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}