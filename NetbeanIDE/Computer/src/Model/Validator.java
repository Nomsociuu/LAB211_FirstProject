
package Model;


import java.util.Scanner;

public class Validator {
     
    public double getInputNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double number;

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                number = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return number;
    }


    public double getValidBMIInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double input;

        while (true) {
            System.out.print(prompt);
            String inputStr = scanner.nextLine();

            try {
                input = Double.parseDouble(inputStr);

                if (input <= 0) {
                    System.out.println("BMI is digit");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }
        }
    }

  
}