package View;

import Model.Fruit;
import Model.Order;
import Model.Validate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private Fruit currentFruit = new Fruit();
    Validate vali = new Validate();
    Scanner scanner = new Scanner(System.in);

    public void displayMainScreen() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Please choose an option (1-4): ");
    }
    
    public void readDataFromFile(String filename) throws IOException, ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String origin = parts[2];
                    int price = Integer.parseInt(parts[3]);
                    if (Validate.isEmpIdValid(id)) {
                        Fruit fr = new Fruit(id, name, origin, price);
                        fruits.add(fr);
                    } else {
                        System.out.println("Typed wrong information format");
                    }
                }
            }
        }
    }

    public void saveDoctorsToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Fruit fr : fruits) {
                writer.println(fr.getId() + ","
                        + fr.getFruitName() + ","
                        + fr.getSemeter()
                        + "," + fr.getCourse());

            }
        } catch (IOException e) {
            throw new IOException("Failed to save data to file: " + filename);
        }
    }

    public void createFruit() {

        int id = fruits.size() + 1;

        System.out.print("Enter Fruit Name: ");
        String name = scanner.nextLine(); //check vali

        System.out.print("Enter Origin: ");
        String origin = scanner.nextLine(); //check vali

        System.out.print("Enter Price: ");
        int price = vali.validatePositiveIntInput("Enter a positive integer for Price: ");

        System.out.print("Enter Quantity: ");
        int quantity = vali.validatePositiveIntInput("Enter a positive integer for Quantity: ");

        Fruit fruit = new Fruit(id, name, origin, price);

        currentFruit.setQuantity(quantity);
        fruits.add(fruit);

        System.out.print("Do you want to continue (Y/N)? ");
        String continueChoice = scanner.next();
        scanner.nextLine();
        if (continueChoice.equalsIgnoreCase("Y")) {
            createFruit();
        } else {
            displayAllFruits();
        }
    }

    public void displayAllFruits() {
    System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");

    for (Fruit fruit : fruits) {
        String formattedId = String.format("%12d", fruit.getId());
        String formattedName = String.format(" %-23s", fruit.getName());
        String formattedOrigin = String.format(" %-15s", fruit.getOrigin());
        String formattedPrice = String.format(" %d$", fruit.getPrice());

        // Combine formatted values and print the row
        String row = String.format("%s %s %s %s", formattedId, formattedName, formattedOrigin, formattedPrice);
        System.out.println(row);
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
