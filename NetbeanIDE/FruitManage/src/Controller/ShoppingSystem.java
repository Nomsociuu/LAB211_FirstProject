package Controller;

import View.Menu;

import java.util.Scanner;

public class ShoppingSystem {

    private Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            displayMainScreen();
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    shopping();
                    break;
                case 4:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    public void displayMainScreen() {
        menu.displayMainScreen();
    }

    public void createFruit() {
        menu.createFruit();
    }

    public void displayAllFruits() {
        menu.displayAllFruits();
    }

    public void viewOrders() {
        menu.viewOrders();
    }

    public void shopping() {
        menu.shopping();
    }
}
