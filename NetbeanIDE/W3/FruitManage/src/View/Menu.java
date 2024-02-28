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
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private Hashtable<String, List<Fruit>> customerOrders = new Hashtable<>();
    Validate vali = new Validate();
    Order ord = new Order();
    Scanner scanner = new Scanner(System.in);

    public Menu() {
        if (fruits.isEmpty()) {
            try {
                readDataFromFile("fruit.txt");
            } catch (IOException | ParseException e) {
                System.out.println("Error reading data from file: " + e.getMessage());
            }
        }
    }

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
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String studentName = parts[1];
                    String origin = parts[2];
                    int price = Integer.parseInt(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);

                    Fruit a = new Fruit(id, studentName, origin, price, quantity);
                    fruits.add(a);
                }
            }
        }
    }

    public void saveDoctorsToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Fruit fr : fruits) {
                writer.println(fr.getId() + ","
                        + fr.getName() + ","
                        + fr.getOrigin() + ","
                        + fr.getPrice() + ","
                        + fr.getQuantity());

            }
        } catch (IOException e) {
            throw new IOException("Failed to save data to file: " + filename);
        }
    }

    public void createFruit() {

        try {

            System.out.print("Enter Fruit ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Fruit Name: ");
            String name = scanner.nextLine(); //check vali

            System.out.print("Enter Origin: ");
            String origin = scanner.nextLine(); //check vali

            System.out.print("Enter Price: ");
            int price = vali.validatePositiveIntInput("Enter a positive integer for Price: ");

            System.out.print("Enter Quantity: ");
            int quantity = vali.validatePositiveIntInput("Enter a positive integer for Quantity: ");

            Fruit fruit = new Fruit(id, name, origin, price, quantity);

            fruits.add(fruit);

            System.out.print("Do you want to continue (Y/N)? ");
            String continueChoice = scanner.next();
            scanner.nextLine();
            if (continueChoice.equalsIgnoreCase("Y")) {
                createFruit();
            } else {
                saveDoctorsToFile("fruit.txt");
                System.out.println("Fruit added successfully.");
                displayAllFruits();
            }

        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void displayAllFruits() {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");

        for (Fruit fruit : fruits) {
            String formattedId = String.format("%7d", fruit.getId());
            String formattedName = String.format(" %18s", fruit.getName());
            String formattedOrigin = String.format(" %15s", fruit.getOrigin());
            String formattedPrice = String.format(" %8d$", fruit.getPrice());

            // Combine formatted values and print the row
            String row = String.format("%s %s %s %s", formattedId, formattedName, formattedOrigin, formattedPrice);
            System.out.println(row);
        }

        System.out.println();
    }

    public void viewOrders() {
        System.out.println("\nOrders List:");
        String Amount = "0";


        for (String customer : customerOrders.keySet()) {
            System.out.println("\nCustomer: " + customer);
            System.out.println("Product | Quantity | Price | Amount");

            // Retrieve and display the list of items for each customer
            List<Fruit> customerItems = customerOrders.get(customer);
            for (Fruit fruit : customerItems) {
                String formattedName = String.format("%6s", fruit.getName());
            String formattedQuantity = String.format(" %7d", fruit.getQuantity());
            String formattedPrice = String.format(" %7d", fruit.getPrice());
            Amount = String.format("%7d", fruit.calculateAmount());
 

            // Combine formatted values and print the row
            String row = String.format("%s %s %s$ %s$",  formattedName, formattedQuantity, formattedPrice,   Amount);
            System.out.println(row);
            
            }
            System.out.print("Total: " + String.format("%s", Amount) + "$\n");
        }

        System.out.println();
    }

    public void shopping() {
        displayAllFruits();

        Order order = new Order();
        System.out.print("Input customer name: ");
        String name = scanner.nextLine();
        order.setCustomerName(name);

        String orderChoice;
        do {
            System.out.print("Select Item to order: ");
            int selectedItem = vali.validateRangeInput(1, fruits.size(),
                    "Select a valid item: ", "Invalid input. Please enter a number.");

            Fruit selectedFruit = fruits.get(selectedItem - 1);
            System.out.println("You selected: " + selectedFruit.getName());

            System.out.print("Please input quantity: ");
            int quantity = vali.validatePositiveIntInput("Enter a positive integer for Quantity: ");
            selectedFruit.setQuantity(quantity);

            order.addFruit(selectedFruit);

            System.out.print("Do you want to order more (Y/N)? ");
            orderChoice = scanner.next();

        } while (orderChoice.equalsIgnoreCase("Y"));

        // Add the order to the hashtable using the customer's name as the key
        customerOrders.computeIfAbsent(name, k -> new ArrayList<>()).addAll(order.getOrderedFruits());

        System.out.println("Orders placed successfully!");
        

        
        viewOrders();
        scanner.nextLine();
    }

}
