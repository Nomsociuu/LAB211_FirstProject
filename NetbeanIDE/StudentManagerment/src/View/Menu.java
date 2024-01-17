package View;

import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    public static void displayMainMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("3. Update/Delete");
        System.out.println("3. Intern");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please choose (1-5): ");
    }

    public static int getUserChoice(int min, int max) {
        int choice;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
            choice = sc.nextInt();
            if (choice < min || choice > max) {
                System.out.println("Invalid choice. Please choose between " + min + " and " + max + ".");
            }
        } while (choice < min || choice > max);

        return choice;
    }
}
