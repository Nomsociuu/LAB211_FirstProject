package View;

import Model.Fruit;
import Model.Order;
import Model.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Fruit> fruits = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private Fruit currentFruit = new Fruit();
    Validate vali = new Validate();

    public void displayMainScreen() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }

    public void createFruit() {
        Scanner scanner = new Scanner(System.in);
        int id = fruits.size() + 1;

        System.out.print("Enter Fruit Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Origin: ");
        String origin = scanner.nextLine();

        System.out.print("Enter Price: ");
        int price = vali.validatePositiveIntInput("Enter a positive integer for Price: ");

        System.out.print("Enter Quantity: ");
        int quantity = vali.validatePositiveIntInput("Enter a positive integer for Quantity: ");

        Fruit fruit = new Fruit(id, name, origin, price);
        currentFruit.setQuantity(quantity);
        fruits.add(fruit);

        System.out.print("Do you want to continue (Y/N)? ");
        String continueChoice = scanner.next();

        if (!continueChoice.equalsIgnoreCase("Y")) {
            displayAllFruits();
        }
    }

    public void displayAllFruits() {
    System.out.println("\nList of Fruits:");
    System.out.println("++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++");

    for (Fruit fruit : fruits) {
        System.out.println(fruit.getId() + " | " + fruit.getName() + " | " + fruit.getOrigin() + " | " + fruit.getPrice());
    }
    System.out.println();
}


    public void viewOrders() {
        System.out.println("\nOrders List:");
        for (Order order : orders) {
            order.displayOrder();
        }
        System.out.println();
    }

    public void shopping() {
        displayAllFruits();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select Item to order: ");
        int selectedItem = vali.validateRangeInput(1, fruits.size(), "Select a valid item: ", "Invalid input. Please enter a number.");

        Fruit selectedFruit = fruits.get(selectedItem - 1);
        System.out.println("You selected: " + selectedFruit.getName());

        System.out.print("Please input quantity: ");
        int quantity = vali.validatePositiveIntInput("Enter a positive integer for Quantity: ");
        selectedFruit.setQuantity(quantity);

        System.out.print("Do you want to order now (Y/N)? ");
        String orderChoice = scanner.next();

        if (orderChoice.equalsIgnoreCase("Y")) {
            System.out.println("\nOrder Summary:");
            Order order = new Order();
            order.setCustomerName(inputCustomerName());

            order.addFruit(selectedFruit);
            orders.add(order);

            System.out.println("Order placed successfully!");
        } else {
            shopping();
        }
    }

    public String inputCustomerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your name: ");
        return scanner.nextLine();
    }
    
}
