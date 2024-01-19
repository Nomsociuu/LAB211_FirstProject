
package Model;

import java.util.Scanner;

public class Validate {
    // Helper method to validate positive integers

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
        Scanner scanner = new Scanner(System.in);
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
}
