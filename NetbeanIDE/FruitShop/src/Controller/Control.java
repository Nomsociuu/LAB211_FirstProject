package Controller;

import View.Manage;
import Model.*;
import View.*;

import java.util.*;

public class Control extends Menu{
    ArrayList<Model> mods = new ArrayList<>();
    //Hashtable<String, ArrayList<Order>> order = new Hashtable<>();
    Hashtable<String, ArrayList<Order>> order = new Hashtable<String, ArrayList<Order>>();
    final Manage controller = new Manage();
    final String filePath = "fruit.txt";

    public Control() {
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
