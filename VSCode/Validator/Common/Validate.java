package Validator.Common;

import java.util.*;

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

    public Float checkFloat(String ms) {
        while (true) {
            try {
                System.out.print(ms);
                return Float.parseFloat(sc.nextLine());
            }
            catch (NumberFormatException n) {
                System.out.println("Please enter valid float number: ");
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

    //validate some optional
    final String isValidPhone = "^[0-9]{10}$";
    final String isValidEmail = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    public String checkPhone(String phoneCheck) {
        boolean breaker = true;
        while (breaker) {
            if (!phoneCheck.matches("\\d{10}") && phoneCheck.matches("[0-9]+")) {
                System.out.println("Phone number must have 10 digits");
                phoneCheck = checkString("Enter phone: ");
            } else if (!phoneCheck.matches("[0-9]+")) {
                System.out.println("Phone number shouldn't contain characters");
                phoneCheck = checkString("Enter phone: ");
            } else {
                return phoneCheck;
            }
        }
        return phoneCheck;
    }
    

    public String checkDate(String dateCheck) {
        boolean breaker = true;
        while (breaker) {
            if (!dateCheck.matches("^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$")) {
                System.err.println("Date must be in correct format (dd/MM/yyyy)");
                dateCheck = checkString("Enter date: ");
            } else {
                return dateCheck;
            }
        }
        return dateCheck;
    }
    

    public String checkEmail(String emailCheck) {
        boolean breaker = true;
        while (breaker) {
            if (!emailCheck.matches(isValidEmail)) {
                System.err.println("Email must be correct format");
                emailCheck = checkString("Enter email: ");
            } else {
                return emailCheck;
            }
        }
        return emailCheck;
    }

}
