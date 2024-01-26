package View;


import java.util.*;

public class Validate {
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

    public String checkStringBasic(String ms) {
        System.out.print(ms);
        return sc.nextLine();
    }

    public String checkStringBetter(String ms) {
        String input;
        do {
            System.out.print(ms);
            input = sc.nextLine();
    
            if (containsNumbers(input)) {
                System.out.println("Invalid input! The string should not contain any number.");
            } else if (containsSpaces(input)) {
                System.out.println("Invalid input! The string should not contain any spaces.");
            }
        } while (containsNumbers(input) || containsSpaces(input));
    
        return input;
    }
    
    private boolean containsNumbers(String input) {
        return input.matches(".*\\d.*");
    }
    
    private boolean containsSpaces(String input) {
        return input.contains(" ");
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
                System.out.println("Please enter valid double number!");
            }
        }
    }
}

