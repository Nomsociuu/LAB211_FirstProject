package View;

import Model.Model;
import Common.Validator;
import java.text.DecimalFormat;
import java.util.Scanner;

public class View {

    private Model model = new Model();
    private Validator vali = new Validator();

    public enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EXPONENT, EQUALS
    }

    public enum BMI {
        UNDER_STANDARD, STANDARD, OVERWEIGHT, SHOULD_LOSE_WEIGHT, SHOULD_LOSE_WEIGHT_IMMEDIATELY
    }

    public void displayMainMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Please choose one option: ");
    }

    public BMI calculateBMI(double weight, double height) {
        if (height <= 0) {
            throw new ArithmeticException("Height should be greater than zero");
        }

        double bmi = weight / (height * height);

        // Format the double with two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedValue = decimalFormat.format(bmi);
        System.out.println("BMI Number: " + formattedValue);

        if (bmi < 19) {
            return BMI.UNDER_STANDARD;
        } else if (bmi <= 25) {
            return BMI.STANDARD;
        } else if (bmi <= 30) {
            return BMI.OVERWEIGHT;
        } else if (bmi <= 40) {
            return BMI.SHOULD_LOSE_WEIGHT;
        } else {
            return BMI.SHOULD_LOSE_WEIGHT_IMMEDIATELY;
        }
    }

    public void bmiCalculator() {
        System.out.println("----- BMI Calculator -----");
        double weight = vali.getValidBMIInput("Enter Weight(kg): ");
        double height = vali.getValidBMIInput("Enter Height(cm): ") / 100; // Convert to meters

        try {
            BMI bmiStatus = calculateBMI(weight, height);
            System.out.println("BMI Status: " + bmiStatus);
        } catch (ArithmeticException e) {
            System.out.println("Error: Height should be greater than zero");
        }
    }

    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        double ans = 0;

        //first enter
        double num0 = vali.getInputNumber("Enter number: ");
        Operator ope = getValidOperator();
        double num1 = vali.getInputNumber("Enter number: ");
        try {
            ans = calculate(num0, ope, num1);
            model.setMemory(ans);
            System.out.println("Memory: " + model.getMemory());
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
        }

        //second and go-on
        while (true) {
            Operator operator = getValidOperator();

            if (operator == Operator.EQUALS) {
                System.out.println("Result: " + model.getMemory());
                break;
            }

            double num2 = vali.getInputNumber("Enter number: ");

            try {
                ans = calculate(model.getMemory(), operator, num2);
                model.setMemory(ans);
                System.out.println("Memory: " + model.getMemory());
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero");
            }
        }
    }

    public Operator getValidOperator() {
        Scanner scanner = new Scanner(System.in);
        Operator operator = null;

        while (operator == null) {
            System.out.print("Enter Operator: ");
            String input = scanner.next();
            operator = checkOperator(input);

            if (operator == null) {
                System.out.println("Please input (+, -, *, /, ^, =)");
            }
        }

        return operator;
    }

    private Operator checkOperator(String operator) {
        switch (operator) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "*":
                return Operator.MULTIPLY;
            case "/":
                return Operator.DIVIDE;
            case "^":
                return Operator.EXPONENT;
            case "=":
                return Operator.EQUALS;
            default:
                return null;
        }
    }
}
