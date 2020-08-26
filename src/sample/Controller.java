package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {
    @FXML
    private Label output;
    private String operator;
    //sup string variable to get number1's value
    private String temp;
    //sup boolean variable for providing multiple operations
    private static boolean flag;
    private double number1;
    private double number2;
    private double result;

    public double calculate(double number1, double number2, String str) {
        switch (str) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 != 0) return number1 / number2;
                else return 0;
            case "^":
                return Math.pow(number1, number2);
            case "%":
                return number1 % number2;
            default:
                return 0;
        }
    }

    @FXML
//number buttons
    public void getNumber(ActionEvent event) {
        temp = ((Button) event.getSource()).getText();
        output.setText(output.getText() + temp);


    }

    @FXML
//operation buttons
    public void getOperator(ActionEvent event) {


        if (flag == false) number1 = Double.parseDouble(output.getText());

        else number1 = calculate(number1, Double.parseDouble(output.getText()), operator);
        operator = ((Button) event.getSource()).getText();
        flag = true;
        output.setText("");
    }

    @FXML
//equals button
    public void getResult(ActionEvent event) {
        number2 = Double.parseDouble(output.getText());
        result = calculate(number1, number2, operator);
        output.setText(result + "");
        flag = false;
    }

    @FXML
    //Clear button
    public void clear(ActionEvent event) {
        flag = false;
        output.setText("");
        operator = "";
        number2 = 0;
        number1 = 0;
    }

}
