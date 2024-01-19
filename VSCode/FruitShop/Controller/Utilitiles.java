package LAB211.FruitShop.Controller;

import LAB211.FruitShop.Model.*;
import LAB211.FruitShop.View.*;

import java.util.*;

public class Utilitiles extends Menu{
    ArrayList<Model> mods = new ArrayList<>();
    //Hashtable<String, ArrayList<Order>> order = new Hashtable<>();
    Hashtable<String, ArrayList<Order>> order = new Hashtable<String, ArrayList<Order>>();
    final Control controller = new Control();
    final String filePath = "C:\\Users\\kleqing\\OneDrive - The Creator\\Documents\\Code\\LAB211\\FruitShop\\fruit.txt";

    public Utilitiles() {
        super("FRUIT SHOP SYSTEM", new String[]{"Create Fruit", "View order", 
                                                        "Shopping", "Exit"});
    }
    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                controller.readFromFile(filePath, mods);
                controller.createFruit(mods);
                break;
            case 2:
                controller.viewOrder(order);
                break;
            case 3:
                //order = new Hashtable<>();
                controller.readFromFile(filePath, mods);
                controller.shop(mods, order);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    // public static void main(String[] args) {
    //     Utilitiles utils = new Utilitiles();
    //     utils.run();
    // }
}
