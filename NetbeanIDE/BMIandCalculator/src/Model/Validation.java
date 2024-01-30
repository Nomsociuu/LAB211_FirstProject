package Model;

import java.util.Scanner;

public class Validation {
    final Scanner sc = new Scanner(System.in);

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
        return sc.nextLine().trim();
    }

    public char checkChar(String ms) {
        System.out.print(ms);
        return sc.nextLine().charAt(0);
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

    public String YesorNo(String ms) {
        while (true) {
            //System.out.print(ms);
            String input = checkString(ms).toUpperCase();

            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                return input;
            }

            System.out.println("Invalid choice. Please enter Y or N: ");
        }
    }
}
