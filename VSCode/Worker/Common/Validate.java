package Common;

import java.util.*;

import Model.*;

public class Validate {
    final Scanner sc = new Scanner(System.in);
    private ArrayList<Model> workers = new ArrayList<>();

    //* Basic check */
    public int checkInt(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                return Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException n) {
                System.out.println("Please enter valid integer number: ");
            }
        }
    }

    public String checkString(String ms) {
        System.out.print(ms);
        return sc.nextLine();
    }

    public Double checkDouble(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                return Double.parseDouble(sc.nextLine());
            }
            catch (NumberFormatException n) {
                System.out.println("Please enter valid double number: ");
            }
        }
    }

    //* Advanced */
    public String YorN(String ms) {
        while (true) {
            //System.out.print(ms);
            String input = checkString(ms).toUpperCase();

            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                return input;
            }

            System.out.println("Invalid choice. Please enter Y or N: ");
        }
    }

    //* Check exist (import first) */
    
    // public boolean checkExistID(ArrayList<Model> list, String id) {
    //     for (Model mod : list) {
    //         if (id.equalsIgnoreCase(mod.getFruitID())) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public boolean checkExistItem(ArrayList<Order> list, String id) {
    //     for (Order or : list) {
    //         if (or.getFruitID().equalsIgnoreCase(id)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public int checkIntLimit(String ms, int min, int max) {
        while (true) {
            try {
                System.out.print(ms);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value < min && value > max) {
                    throw new NumberFormatException();
                }
                return value;
            }
            catch (NumberFormatException nfe) {
                System.out.print("Number can only in range " + min + " and " + max + ": ");
            }
        }
    }

    public boolean checkID(Model w) {
        if (w.getID() == null || w.getID().isEmpty()) {
            return false;
        }
        for (Model worker : workers) {
            if (worker.getID().equals(w.getID())) {
                return false;
            }
        }
        workers.add(w);
        return true;
    }

}
