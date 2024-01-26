package Controller;

import java.util.*;

import Model.*;

public class Calculator {

    final Scanner sc = new Scanner(System.in);
    final Validate validate = new Validate();
    final Model model = new Model();

    public List<Double> SuperlativeEquation (double A, double B) {
        A = validate.checkDouble("Enter A: ");
        B = validate.checkDouble("Enter B: ");
        model.setA(A);
        model.setB(B);
        List<Double> values = new ArrayList<>();
        if (A == 0 && B != 0) {
            return null;
        }
        else if (A == 0 && B == 0) {
            return values;
        }
        else if (A != 0){
            // model.setA(A);
            // model.setB(B);
            double result = -B/A;
            values.add(result);
            values.add(A);
            values.add(B);
            
        }
        // double A = validate.checkDouble("Enter A: ");
        // double B = validate.checkDouble("Enter B: ");
        // model.setSaved(result);
        // System.out.println("Solution: " + result);
        return values;
    }

    public List<Double> QuadraticEquation(double A, double B, double C) {
        A = validate.checkDouble("Enter A: ");
        B = validate.checkDouble("Enter B: ");
        C = validate.checkDouble("Enter C: ");
        List<Double> values = new ArrayList<>();
        model.setA(A);
        model.setB(B);
        model.setC(C);
        // if (A == 0 && B == 0 && C == 0) {
        //     return values;
        // }
        double delta = (B*B - 4*A*C);
        if (delta < 0) {
            return null;
        }
        else if (delta == 0) {
            // values.add(- B / (2*A));
            // values.add(- B / (2*A));
            double x1 = - B / (2*A);
            double x2 = - B / (2*A);
            values.add(x1);
            values.add(x2);
            //values.add(x);
            // System.out.print("One solution: " + delta);
            values.add(A);
            values.add(B);
            values.add(C);
        }
        else if (delta > 0) {
            double x1 = (-B - (double) Math.sqrt(delta))/(2*A);
            double x2 = (-B + (double) Math.sqrt(delta))/(2*A);
            values.add(x1);
            values.add(x2);
            values.add(A);
            values.add(B);
            values.add(C);
        }
        //System.out.println(result);
        // printEven(A, B, C);
        // printOdd(A, B, C);
        // printSquare(A, B, C);
        return values;
    }

}
