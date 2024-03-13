package Common;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validate {
 //check : only boolean
    private final DateTimeFormatter dateFormatt = DateTimeFormatter.ofPattern("dd-mm-yyyy");

    public boolean checkDate(String date){
        try{
            LocalDate.parse(date,dateFormatt);
            return true;
        } catch(DateTimeParseException e){
            return false;
        }
    }
    
    public LocalDate parseDate(String date){
        return LocalDate.parse(date,dateFormatt);
    }
    
    public boolean checkPositiveNum(double num){
        return num > 0;
    }
    
    public boolean checkString(String str){
        return str !=null && !str.trim().isEmpty();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public int getIntFromInput(String msg) { //re-enter Int till correct format
//        int number;
//        while (true) {
//            System.out.print(String.format("%s", msg));
//            try {
//                number = scanner.nextInt();
//                if (number >= 0) {
//                    return number;
//                } else {
//                    System.err.println("Please enter the integer number > 0 ");
//                }
//            } catch (InputMismatchException e) {
//                System.err.println("Just input the integer number > 0 ");
//                scanner.next();
//            }
//        }
//    }
//
//    public float getFloatFromInput(String msg, float min) { //re-enter Float till correct format
//        float number;
//        while (true) {
//            System.out.print(String.format("%s", msg));
//            try {
//                number = scanner.nextFloat();
//                if (number > min) {
//                    return number;
//                } else {
//                    System.err.println("Please enter the float number > " + min);
//                }
//            } catch (InputMismatchException e) {
//                System.err.println("Just input the float number > 0 ");
//                scanner.next();
//            }
//        }
//    }
//
//    public double getDoubleFromInput(String msg) { //re-enter Double till correct format
//        double number;
//        while (true) {
//            System.out.print(String.format("%s", msg));
//            try {
//                number = scanner.nextDouble();
//                if (number > 0) {
//                    return number;
//                } else {
//                    System.err.println("Please enter the number > 0 ");
//                }
//            } catch (InputMismatchException e) {
//                System.err.println("Just input the double number > 0 ");
//                scanner.next();
//            }
//        }
//    }
//
//    public char getCharFromInput(String msg) { //re-enter Char till correct format
//        char c = '\0';
//        boolean isValidInput = false;
//
//        while (!isValidInput) {
//            System.out.print(String.format("%s", msg));
//            String input = scanner.nextLine().trim();
//
//            if (input.length() == 1) {
//                c = input.charAt(0);
//                isValidInput = true;
//            } else {
//                System.out.println("Please enter a single character.");
//            }
//        }
//
//        return c;
//    }
//
//    public String getStringFromInput(String msg) { //re-enter String till correct format
//        String s = null;
//        while (s == null || s.isEmpty()) {
//            System.out.print(String.format("%s", msg));
//            s = scanner.nextLine();
//        }
//        return s;
//    }
//
//    public String inputPattern(String msg, String pattern) { //re-enter input till match pattern
//        String data;
//        do {
//            System.out.print(msg);
//            data = scanner.nextLine();
//        } while (!data.matches(pattern));
//        return data;
//    }
//
//    public String getAlphabelticStringFromInput(String msg) { //re-enter input till match format
//        String data;
//        do {
//            System.out.print(msg);
//            data = scanner.nextLine();
//        } while (!data.matches("[a-zA-Z\\s]{0,30}+$"));
//        return data;
//    }
//
//    public Date getDateFromInput(String msg) { //re-enter Date till correct format
//        while (true) {
//            System.out.print(String.format("Enter %s: ", msg));
//            String dateString = scanner.nextLine();
//            if (!dateString.isEmpty()) {
//                try {
//                    Date date = dateFormat.parse(dateString);
//                    return date;
//                } catch (ParseException e) {
//                    System.err.println(String.format("Invalid date format. Please enter again (%s).", DATE_FORMAT));
//                }
//            }
//        }
//    }
//
//    public int getIntInRange(String msg, int m, int n) { //re-enter int till in range
//        int number;
//        while (true) {
//            System.out.print(String.format("%s", msg));
//
////            if String replace with List<String> then the line above replace with
////            for (int i = 0; i < msg.size(); i++) {
////            System.out.println((i + 1) + ". " + msg.get(i));
//            try {
//                number = scanner.nextInt();
//                if (number >= m && number <= n) {
//                    break;
//                } else {
//                    System.err.println("Please enter a number from " + m + " to " + n);
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Wrong format !!");
//                scanner.next();
//            }
//        }
//        return number;
//    }
//
////Specific
//    public String convertNumberToString(Number number) {
//        return String.valueOf(number); // Convert a number (integer or double) to a string
////        return Integer.parseInt(input); // Convert a string to an integer
////        return Double.parseDouble(input); // Convert a string to a double
//    }
//
//    public Date convertStringToDate(String input, String dateFormat) throws ParseException { // Convert a string to a date
//        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
//        return sdf.parse(input);
//    }
//
//    public boolean checkInt(String input) { //replace Int into Double if neccessary
//        try {
//            Integer.parseInt(input);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
//    public boolean checkIdFormat(String id) {
//        // Implement your ID format validation logic here
//        // Example: Assume valid if ID is non-empty and alphanumeric
//        return id != null && !id.isEmpty() && id.matches("^[a-zA-Z0-9]+$");
//    }
//
//    public boolean checkString(String input) {
//        // Implement your string validation logic here
//        // Example: Assume valid if the string is not empty
//        return input != null && !input.isEmpty();
//    }
//
//    public boolean checkStringFormat(String input, String regex) { //// Check String follows a specific format
//        return input != null && input.matches(regex);
//    }
//
//    public boolean checkDate(String input, String dateFormat) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
//            sdf.setLenient(false);
//            sdf.parse(input);
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
//    }

}
