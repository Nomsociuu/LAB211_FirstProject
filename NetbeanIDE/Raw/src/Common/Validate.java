
package Common;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class Validate {
    
    public Scanner scanner;
    
    public Validate() {
        scanner = new Scanner(System.in);
    }
    
//---------------------------------------------------------------------------------------------------------------------- 
    private static final String DATE_FORMAT = "yyyy/MM/dd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    
    public int getIntFromInput(String msg) { //re-enter Int till correct format
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the integer number > 0 ");
                sc.next();
            }
        }
    }
    
    public float getFloatFromInput(String msg, float min) { //re-enter Float till correct format
        Scanner sc = new Scanner(System.in);
        float number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextFloat();
                if (number > min) {
                    return number;
                } else {
                    System.err.println("Please enter the float number > " + min);
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the float number > 0 ");
                sc.next();
            }
        }
    }
    
    public double getDoubleFromInput(String msg) { //re-enter Double till correct format
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextDouble();
                if (number > 0) {
                    return number;
                } else {
                    System.err.println("Please enter the number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the double number > 0 ");
                sc.next();
            }
        }
    }
    
    public char getCharFromInput(String msg) { //re-enter Char till correct format
        Scanner sc = new Scanner(System.in);
        char c = '\0';  // Default value
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print(String.format("%s", msg));
            String input = sc.nextLine().trim();

            if (input.length() == 1) {
                c = input.charAt(0);
                isValidInput = true;
            } else {
                System.out.println("Please enter a single character.");
            }
        }

        return c;
    }
    
    public String getStringFromInput(String msg) { //re-enter String till correct format
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print(String.format("%s", msg));
            s = sc.nextLine();
        }
        return s;
    }
    
    public String inputPattern(String msg, String pattern) { //re-enter input till match pattern
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches(pattern));
        return data;
    }
    
    public String getAlphabelticStringFromInput(String msg) { //re-enter input till match format
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine();
        } while (!data.matches("[a-zA-Z\\s]{0,30}+$"));
        return data;
    }
    
    public Date getDateFromInput(String msg) { //re-enter Date till correct format
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(String.format("Enter %s: ", msg));
            String dateString = sc.nextLine();
            if (!dateString.isEmpty()) {
                try {
                    Date date = dateFormat.parse(dateString);
                    return date;
                } catch (ParseException e) {
                    System.err.println(String.format("Invalid date format. Please enter again (%s).", DATE_FORMAT));
                }
            }
        }
    }
    
//Another specific
    
    public int getIntInRange(String msg, int m, int n) { //re-enter int till in range
        int number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                String s = scanner.nextLine();
                number = Integer.parseInt(s);
                if (number >= m && number <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Enter a number from " + m + " to " + n);
            }
        }
        return number;
    }

    public int getAgeInRange(String msg) {  //re-enter age till in range
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s", msg));
            try {
                number = sc.nextInt();
                if (number >= 18 && number <=50) {
                    return number;
                } else {
                    System.err.println("Please enter age in rage 18 to 50!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just enter age in rage 18 to 50!");
                sc.next();
            }
        }
    }

    public int inputPositiveInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print(String.format("%s: ", msg));
            try {
                number = sc.nextInt();
                if (number > 0 && number < 10000) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number > 0 ");
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }

    public int inputChoiceHasLimit(List<String> msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            for (int i = 0; i < msg.size(); i++) {
            System.out.println((i + 1) + ". " + msg.get(i));
        }
            try {
                number = sc.nextInt();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println("Please enter the integer number from "+min +" to "+max);
                }
            } catch (InputMismatchException e) {
                System.err.println("Just input the integer number ");
                sc.next();
            }
        }
    }
  
//----------------------------------------------------------------------------------------------------------------------   
    // Check if the given ID follows a specific format
        public static boolean checkIdFormat(String id) {
            // Implement your ID format validation logic here
            // Example: Assume valid if ID is non-empty and alphanumeric
            return id != null && !id.isEmpty() && id.matches("^[a-zA-Z0-9]+$");
        }

        // Check if the given input is an integer
        public static boolean checkInt(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        // Check if the given input is a valid string
        public static boolean checkString(String input) {
            // Implement your string validation logic here
            // Example: Assume valid if the string is not empty
            return input != null && !input.isEmpty();
        }

        // Check if the given input is a valid double
        public static boolean checkDouble(String input) {
            try {
                Double.parseDouble(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        // Check if the given input is a valid date in a specific format
        public static boolean checkDate(String input, String dateFormat) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                sdf.setLenient(false);
                sdf.parse(input);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }

        // Check if the given string follows a specific format
        public static boolean checkStringFormat(String input, String regex) {
            return input != null && input.matches(regex);
        }

        // Check if the given string does not contain any numbers
        public static boolean checkStringNoNumber(String input) {
            return input != null && !input.matches(".*\\d.*");
        }

        // Convert a number (integer or double) to a string
        public static String convertNumberToString(Number number) {
            return String.valueOf(number);
        }

        // Convert a string to an integer
        public static int convertStringToInt(String input) {
            return Integer.parseInt(input);
        }

        // Convert a string to a double
        public static double convertStringToDouble(String input) {
            return Double.parseDouble(input);
        }

        // Convert a string to a date
        public static Date convertStringToDate(String input, String dateFormat) throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            return sdf.parse(input);
        }

        public static void main(String[] args) {
            // Example usage
            String id = "ABC123";
            if (checkIdFormat(id)) {
                System.out.println("ID is valid");
            } else {
                System.out.println("ID is not valid");
            }

            String intInput = "123";
            if (checkInt(intInput)) {
                System.out.println("Integer is valid");
            } else {
                System.out.println("Integer is not valid");
            }

            String dateInput = "2024-02-28";
            String dateFormat = "yyyy-MM-dd";
            if (checkDate(dateInput, dateFormat)) {
                System.out.println("Date is valid");
            } else {
                System.out.println("Date is not valid");
            }
        }
}
