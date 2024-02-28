/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.util.List;

/**
 *
 * @author kleqing
 */
public class Library {
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
}
