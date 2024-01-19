
package Model;

import java.util.Scanner;

public class Validate {
    private static String id;
    static Scanner scanner = new Scanner(System.in);

    public int validatePositiveIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            input = scanner.nextInt();
        } while (input <= 0);
        return input;
    }

    // Helper method to validate input within a specified range
    public int validateRangeInput(int min, int max, String prompt, String errorMessage) {
        
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(errorMessage);
                scanner.next(); // Consume the invalid input
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }
    public static String getIDString() {
        return id;
    }

    public static boolean isEmpIdValid(String empId) {
        return empId.matches("ST\\d{3}");
    }

    public static boolean validDoc() {
        do {
            id = scanner.nextLine();
            if (id.matches("ST\\d{3}")) {
                return true;
            } else {
                System.out.println("The Student must follow format 'STxxx' with x is digit");
                System.out.print("Enter Student ID: ");
            }
        } while (true);
    }
}
