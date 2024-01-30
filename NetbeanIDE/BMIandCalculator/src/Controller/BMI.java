package Controller;

// import java.text.DecimalFormat;
// import java.math.RoundingMode;
import java.util.*;

// import LAB211.BMI.Model.*;
import Model.BMIdata;
import Model.Validation;

public class BMI {

    final Scanner sc = new Scanner(System.in);
    final Validation validate = new Validation();
    final BMIdata BMI = new BMIdata();
    //final DecimalFormat df = new DecimalFormat("0.00");

    public void Calculate() {
        double weight = validate.checkInt("Enter weight (kg): ");
        BMI.setWeight(weight);
        double height = validate.checkInt("Enter height (cm): ");
        BMI.setHeight(height);
        height = height / 100;
        double result = (weight / (height * height)); // = validate.checkDouble("");
        BMI.setBMI(result);
        BMIStatus();
        Print();
    }

    public void BMIStatus() {
        double result = BMI.getBMI();
        String status;
        if (result < 19) {
            status = "Under-standard";
            BMI.setStatus(status);
        }
        else if (result > 19 && result < 25) {
            status = "Standard";
            BMI.setStatus(status);
        }
        else if (result > 25 && result < 30) {
            status = "Overweight";
            BMI.setStatus(status);
        }
        else if (result > 30 && result < 40) {
            status = "sFat - should lose weight";
            BMI.setStatus(status);
        }
        else if (result > 40) {
            status = "Very fat - should lose weight immediately";
            BMI.setStatus(status);
        }

    }

    public void Print() {
        System.out.printf("BMI Number: %.2f\n", BMI.getBMI());
        System.out.println("Status: " + BMI.getStatus() + "\n");
        
    }

    // public static void main(String[] args) {
    //     new BMI().Calculate();
    // }
}
