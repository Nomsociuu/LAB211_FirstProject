package Common;

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

    public String checkPhone(String ms ) {
        System.out.print(ms);
        String phone = sc.nextLine();
        // Validating phone number format
        if (!phone.matches("\\d{10}|\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}|\\(\\d{3}\\)[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}|\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}\\s?x?\\d*")) {
            System.out.println("Please input a valid phone number. Examples:");
            System.out.println("• 1234567890");
            System.out.println("• 123-456-7890");
            System.out.println("• 123-456-7890 x1234");
            System.out.println("• (123)-456-7890");
            System.out.println("• 123.456.7890");
            System.out.println("• 123 456 7890");
            System.out.print("Enter phone number: ");
            return sc.nextLine(); // Recursively ask for input
        }
        return phone;
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
