package View;

// CandidateManagementView.java
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Please choose (1-5): ");
    }

    public static int getUserChoice(int min, int max) {
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < min || choice > max) {
                System.out.println("Invalid choice. Please choose between " + min + " and " + max + ".");
            }
        } while (choice < min || choice > max);

        return choice;
    }

    // Other methods for user input and display as needed
}

