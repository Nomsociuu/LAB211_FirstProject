    package LAB211.FruitShop.Controller;

    import LAB211.FruitShop.Model.*;
    import LAB211.FruitShop.View.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

    public class Control {
        //public ArrayList<Model> fruits;
        //public HashMap<String, ArrayList<Model>> order;
        // ArrayList<Model> mods = new ArrayList<>();
        // HashMap<String, ArrayList<Order>> order;
        //Hashtable<String, ArrayList<Order>> order = new Hashtable<>();

        private final Validate validate = new Validate();

        // public Control() {
        //     super("FRUIT SHOP SYSTEM", new String[]{"Create Fruit", "View order", 
        //                                                     "Shopping", "Exit"});
        // }

        // public void execute(int choice) {
        //     switch (choice) {
        //         case 1:
        //             createFruit(mods);
        //             break;
        //         case 2:
        //             view(order);
        //             break;
        //         case 3:
        //             shop(mods, order);
        //             break;
        //         case 4:
        //             System.exit(0);
        //             break;
        //     }
        // }

        // public static void main(String[] args) {
        //     Control controller = new Control();
        //     controller.run();
        // // public Control() {
        // //     this.fruits = new ArrayList<>();
        // //     this.order = new HashMap<>();
        // // }

        //! TEST ONLY

    public void readFromFile(String filePath, ArrayList<Model> mods) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                //* "\\s+" la dau cach */
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    double price = Double.parseDouble(parts[3].trim());
                    String origin = parts[4].trim();

                    Model model = new Model(id, name, price, quantity, origin);
                    mods.add(model);
                } else {
                    System.out.println("Invalid data format at: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFruit(ArrayList<Model> fruit) {
        boolean runner = true;
        while (runner) {
            String id;
            id = validate.checkString("Enter fruit id: ");
            if (!validate.checkExistID(fruit, id)) {
                System.out.println("ID already exists! Please choose a different!");
                id = validate.checkString("Enter fruit id: ");
            }
            String name = validate.checkString("Enter fruit name: ");
            double price = validate.checkDouble("Enter price: ");
            int quantity = validate.checkInt("Enter quantity: ");
            String origin = validate.checkString("Enter origin: ");
            Model mods = new Model(id, name, price, quantity, origin);
            fruit.add(mods);

            System.out.println("Fruit added!");
            String check = validate.YorN("Do you want to continue? (Y/N): ");
            if (check.equalsIgnoreCase("Y")) {
                runner = true;
            } 
            else if (check.equalsIgnoreCase("N")) {
                runner = false;
            }
        //Model newFruit = new Model(id, name, price, quantity, origin);
        }
    }
    
    public void shop(ArrayList<Model> mods, Hashtable<String, ArrayList<Order>> order) {
        if (mods == null) {
            System.out.print("Empty");
        }
        ArrayList<Order> or = new ArrayList<>();
            // System.out.print("Enter fruit: ");
            // int id = 1;
        boolean ordering = true;
        do {
            displayList(mods);
            System.out.print("Enter item to buy: ");
            //int item  = validate.checkInt("Enter item to buy: ");
            int item = validate.checkIntLim(1, mods.size());
            //Model mods = fruits.get(item - 1);
            Model md = getItem(mods, item);
            System.out.print("Enter quantity: ");
            int quantity = validate.checkIntLim(1, md.getFruitQuantity());
            md.setFruitQuantity(md.getFruitQuantity() - quantity);

            if (!validate.checkExistItem(or, md.getFruitID())) {
                for (Order orderin : or) {
                    if (orderin.getFruitID().equalsIgnoreCase(md.getFruitID())) {
                        orderin.setFruitQuantity(orderin.getFruitQuantity() + quantity );
                    }
                }
            }
            else {
                Order neworder = new Order(md.getFruitID(), md.getFruitName(), quantity, md.getFruitPrice());
                or.add(neworder);
                // or.add(new Order(md.getFruitID(), md.getFruitName(), quantity, md.getFruitPrice()));
            }
            String check = validate.YorN("Do you want to continue? (Y/N): ");
            if (check.equalsIgnoreCase("N")) {
                ordering = false;
            } 
            else if (check.equalsIgnoreCase("Y")) {
                ordering = true;
            }
                //Model newFruit = new Model(id, name, price, quantity, origin);
                
        }
        while (ordering);
        displayOrder(or);
        String myname = validate.checkString("Enter your name: ");
        order.put(myname, or);
        System.out.println();
    }

    public Model getItem(ArrayList<Model> models, int item) {
        int count = 1;
        for (Model model : models) {
            if (model.getFruitQuantity() != 0) {
                count++;
            }
            if (count - 1 == item) {
                return model;
            }
        }
        return null;
    }

    public void viewOrder(Hashtable<String, ArrayList<Order>> or) {
        for (String name : or.keySet()) {
            System.out.println("Buyer: " + name );
            ArrayList<Order> orders = or.get(name);
            displayOrder(orders);
        }
    }

    public void displayList(ArrayList<Model> mods) {
        int count = 1;
        System.out.printf("%-10s%-20s%-20s%-20s%-15s\n", "Item", "Fruit name", "Quantity", "Origin", "Price");
        for (Model md : mods) {
            if (md.getFruitQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-20s%-15.0f$\n", count++, md.getFruitName(), md.getFruitQuantity(), md.getOrigin(), md.getFruitPrice());
            }
        }
    }

    public void displayOrder(ArrayList<Order> or) {
        double check = 0;
        System.out.printf("%15s%15s%15s%15s\n", 
                    "Product", "Quantity", 
                    "Price", "Amount");
        for (Order order : or) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(), 
                order.getFruitQuantity(), order.getFruitPrice(), 
                order.getFruitPrice() * order.getFruitQuantity());
            check += order.getFruitPrice() * order.getFruitQuantity();
        }
        System.out.println("Totoal: " + check);
    }
}
