package LAB211.Calculate.Controller;

import java.util.*;
import java.io.*;

import LAB211.Calculate.View.*;
import LAB211.Calculate.Model.*;

public class Control extends Menu{
    public Control() {
        super("Equation Program", new String[] {"Calculate Superlative Equation",
                "Calculate Quadratic Equation", "Exit"});
    }
    final Scanner sc = new Scanner(System.in);
    final Validate validate = new Validate();
    final Model model = new Model();
    final Calculator calc = new Calculator();
    // public void SuperlativeEquation() {
    //     List<Double> values = new ArrayList<>();
    //     double A = validate.checkDouble("Enter A: ");
    //     double B = validate.checkDouble("Enter B: ");
    //     model.setA(A);
    //     model.setB(B);

    //     double result = -B/A;
    //     model.setSaved(result);
    //     System.out.println("Solution: " + result);

    // }

    // public void QuadraticEquation() {
    //     double A = validate.checkDouble("Enter A: ");
    //     double B = validate.checkDouble("Enter B: ");
    //     double C = validate.checkDouble("Enter C: ");

    //     model.setA(A);
    //     model.setB(B);
    //     model.setC(C);

    //     double result = (-B + Math.sqrt(B*B - 4*A*C))/(2*A);
    //     if (result < 0) {
    //         System.out.print("No solution");
    //     }
    //     else if (result == 0) {
    //         double result1 = - B / (2*A);
    //         System.out.print("One solution: " + result1);
    //     }
    //     else {
    //         double result1 = (-B - Math.sqrt(B*B - 4*A*C))/(2*A);
    //         double result2 = (-B + Math.sqrt(B*B - 4*A*C))/(2*A);
    //         System.out.print("Two solutions: " + result1 + " and " + result2);
    //     }
    //     //System.out.println(result);
    //     // printEven(A, B, C);
    //     // printOdd(A, B, C);
    //     // printSquare(A, B, C);
    // }

    public boolean printEven(double result) {
        if (result % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    } 
    
    public boolean printOdd(double result) {
        if (result % 2 != 0) {
            return true;
        }
        else {
            return false;
        }
    } 

    public boolean printSquare(double result) {
        if (result > 0) {
            int sr = (int)Math.sqrt(result);
            return (sr *sr==result);
        }
        return false;
    } 

    public void checkEven(List<Double> values) {
        String regex = "";
        System.out.print("Even number: ");
        for (Double value : values) {
            if (printEven(value)){
                System.out.print(regex + value);
                regex = ", ";
            }
        }
        System.out.println();
    }

    public void checkOdd(List<Double> values) {
        String regex = "";
        System.out.print("Odd number: ");
        for (Double value : values) {
            if (printOdd(value)){
                System.out.print(regex + value);
                regex = ", ";
            }
        }
        System.out.println();
    }

    public void checkSquare(List<Double> values) {
        String regex = "";
        System.out.print("Square number: ");
        for (Double value : values) {
            if (printSquare(value)){
                System.out.print(regex + value);
                regex = ", ";
            }
        }
        System.out.println();
    }

    double A, B, C;

    public void execute(int choice) {
        List<Double> values = new ArrayList<>();
        switch (choice) {
            case 1:
                A = model.getA();
                B = model.getB();
                values = calc.SuperlativeEquation(A, B);                
                if (values == null){
                    System.out.println("No solution");
                }
                else if (values.size() == 0) {
                    System.out.println("Infinity solution");
                }
                else {
                    System.out.println("Solution: " + values.get(0));
                    checkEven(values);
                    checkOdd(values);
                    checkSquare(values);

                }
                //calc.SuperlativeEquation();
                break;
            case 2:
                A = model.getA();
                B = model.getB();
                C = model.getC();
                values = calc.QuadraticEquation(A, B, C);
                if (values == null){
                    System.out.println("No solution");
                }
                else if (values.size() == 0 ){
                    System.out.print("One solution");
                    System.out.println("x = " + values.get(0));
                }

                else {
                    System.out.println("x1 = " + values.get(0));
                    System.out.println("x2 = " + values.get(1));
                    checkEven(values);
                    checkOdd(values);
                    checkSquare(values);
                }
                

                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    // public static void main(String[] args){
        
    //     Control controller = new Control();  
    //     controller.run();
    // }

}
