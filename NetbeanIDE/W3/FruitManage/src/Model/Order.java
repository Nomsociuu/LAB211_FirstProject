package Model;

import java.util.ArrayList;

public class Order {

    private String customerName;
    private ArrayList<Fruit> orderedFruits = new ArrayList<>();

    public ArrayList<Fruit> getOrderedFruits() {
        return orderedFruits;
    }

    public void setOrderedFruits(ArrayList<Fruit> orderedFruits) {
        this.orderedFruits = orderedFruits;
    }
    

    public void addFruit(Fruit fruit) {
        orderedFruits.add(fruit);
    }

    public String getCustomerName() {
        return customerName;
    }

    public int calculateTotalAmount() {
        int totalAmount = 0;
        for (Fruit fruit : orderedFruits) {
            totalAmount += fruit.calculateAmount();
        }
        return totalAmount;
    }

    

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
