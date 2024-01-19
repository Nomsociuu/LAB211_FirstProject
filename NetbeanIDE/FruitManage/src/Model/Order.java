package Model;

import java.util.ArrayList;

public class Order {

    private String customerName;
    private ArrayList<Fruit> orderedFruits = new ArrayList<>();

    public void addFruit(Fruit fruit) {
        orderedFruits.add(fruit);
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Fruit fruit : orderedFruits) {
            totalAmount += fruit.calculateAmount();
        }
        return totalAmount;
    }

    public void displayOrder() {
        System.out.println("\nCustomer: " + customerName);
        System.out.println("Product | Quantity | Price | Amount");

        for (Fruit fruit : orderedFruits) {
            System.out.print("| " + fruit.getName()
                    + " | " + fruit.getQuantity()
                    + " | " + fruit.getPrice()
                    + " | " + String.format("%.2f", fruit.calculateAmount()) + " |\n");
        }

        System.out.print("Total: " + String.format("%.2f", calculateTotalAmount()) + " $\n");
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
