package Package;

import java.util.*;
import Model.*;

public class Validate {

    final Scanner sc = new Scanner(System.in);
    //* Basic check */
    public int checkInt(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                return Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException n) {
                System.out.println("Please enter valid integer number!");
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
                System.out.println("Please enter valid double number!");
            }
        }
    }

    public Float checkFloat(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                return Float.parseFloat(sc.nextLine());
            }
            catch (NumberFormatException n) {
                System.out.println("Please enter valid float number!");
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

    // public boolean isValidWorkerId(String id, List<Model> models) {
    //     if (id == null || id.isEmpty()) {
    //         return false;
    //     }
    //     for (Model worker : models) {
    //         if (worker.getCode().equals(id)) {
    //             return true; // ID exists
    //         }
    //     }
    //     return false; // ID does not exist
    // }

    //* Check exist (import first) */
    
    public int checkExistID(ArrayList<Model> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == id) {
                return i;
            }
        }
        return -1;
    }

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
                System.out.print("Number can only in range " + min + " and " + max + "!");
            }
        }
    }

    public String checkDate(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                String date = sc.nextLine().trim();
                if (date.matches("^\\d{1}|[0-3]{1}\\d{1}-[a-zA-Z]{3}-\\d{4}$")) {
                    return date;
                }
                else {
                    System.out.println("Date format invalid");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Date format invalid");
            }
        }
    }
}
