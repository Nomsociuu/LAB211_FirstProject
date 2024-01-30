package Controller;

import Model.Validation;
import Model.Calculatordata;

import java.util.*;

//* If user divide 0, print error 
//! Can't prompt enter again!*/


public class Calculator {
    final Scanner sc = new Scanner(System.in);
    final Validation validate = new Validation();
    final Calculatordata calc = new Calculatordata();

    private enum Operator {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        POWER,
        EQUALS
    }

    public Operator checkOperator(Scanner sc) {
        while (true) {
            String check = validate.checkString("Enter an operator: ");
            if (check.equals("+")) {
                return Operator.ADD;
            }
            else if (check.equals("-")) {
                return Operator.SUBTRACT;
            }
            else if (check.equals("*")) {
                return Operator.MULTIPLY;
            }
            else if (check.equals("/")) {
                return Operator.DIVIDE;
            }
            else if (check.equals("^")) {
                return Operator.POWER;
            }
            else if (check.equals("=")) {
                return Operator.EQUALS;
            }
            // else {
            //     System.out.println("Please input (+, -, *, /, ^)");
            //     System.out.print("Enter an operator: ");
            // }
            try {
                return Operator.valueOf(check.toLowerCase());

            }
            catch (IllegalArgumentException e) {
                System.out.println("Please input (+, -, *, /, ^)");
            }
        }
    }

    public double calculate(Operator op, double number1, double number2)  {
        switch (op) {
            case ADD:
                double sum = number1 + number2;
                return sum;
            case SUBTRACT:
                double sub = number1 - number2;
                return sub;
            case MULTIPLY:
                double mul = number1 * number2;
                return mul;
            case DIVIDE:
                double div = number1 / number2;
                if (number2 == 0) {
                    throw new ArithmeticException("0 can't be divide");
                }
                else {
                    return div;
                }
            case POWER:
                double pow = Math.pow(number1, number2);
                return pow;
            case EQUALS:
                // System.out.println("Result: " + calc.getResult());
                return calc.getResult();
                //break;
        }
        return 0;
    }

    public void Memory () {
        boolean loop = true;
        do {
            double number1 = validate.checkDouble("Enter number: ");
            Operator op = checkOperator(sc);
            double number2 = validate.checkDouble("Enter number: ");

            try {
                double memory = calculate(op, number1, number2);
                calc.setMemory(memory);
                System.out.println("Memory: " + memory);
                calc.setResult(memory);
                loop = false;
            }
            catch (ArithmeticException e) {
                e.printStackTrace();
            }
        }
        while (loop);
        Loop();
    }

    public void Loop() {
        do {
            Operator op = checkOperator(sc);
            if (op == Operator.EQUALS) {
                double result = calculate(op, calc.getResult(), 0);
                System.out.println("Result: " + result + "\n");
                break;
            }
            double number3 = validate.checkDouble("Enter number: ");

            try {
                double memory = calculate(op, calc.getMemory(), number3);
                calc.setMemory(memory);
                System.out.println("Memory: " + memory);
                calc.setResult(memory);
                // String breaker = validate.YesorNo("Do you want to continue: ");
                // if (breaker.equalsIgnoreCase("N")) {
                //     break;
                // }
                // else if (breaker.equalsIgnoreCase("Y")){
                //     //calc.setResult(memory);
                //     continue;
                // }
            }
            catch (ArithmeticException e) {
                e.printStackTrace();
            }
        }
        while (true);
    }

    // public static void main(String args[]) {
    //     Calculator test = new Calculator();
    //     test.Memory();
    // }
}