package Model;

import java.util.List;
import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);
    private static String id;
    
    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {

        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String getIDString() {
        return id;
    }

    public static boolean isEmpIdValid(String empId) {
        return empId.matches("ST\\d{3}");
    }

    public static boolean validDoc() {
        do {
            id = in.nextLine();
            if (id.matches("ST\\d{3}")) {
                return true;
            } else {
                System.out.println("The Student must follow format 'STxxx' with x is digit");
                System.out.print("Enter Student ID: ");
            }
        } while (true);
    }
}
