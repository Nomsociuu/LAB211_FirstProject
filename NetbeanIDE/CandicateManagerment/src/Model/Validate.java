
package Model;

import java.util.Scanner;

public class Validate {
    static final Scanner scanner = new Scanner(System.in); 

    public static String getBirthDate() {
        String birthDate;
        do {
            System.out.print("Enter Birth Date (yyyy): ");
            birthDate = scanner.next();
        } while (!isValidBirthDate(birthDate));
        return birthDate;
    }

    public static boolean isValidBirthDate(String birthDate) {
        try {
            int year = Integer.parseInt(birthDate);
            int currentYear = java.time.Year.now().getValue();
            return year >= 1900 && year <= currentYear;
        } catch (NumberFormatException e) {
            System.out.println("Invalid birth date. Please enter a valid year.");
            return false;
        }
    }


    public static String getPhone() {
        String phone;
        do {
            System.out.print("Enter Phone (minimum 10 digits): ");
            phone = scanner.next();
        } while (!isValidPhone(phone));
        return phone;
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10,}");
    }

    public static String getEmail() {
        String email;
        do {
            System.out.print("Enter Email: ");
            email = scanner.next();
        } while (!isValidEmail(email));
        return email;
    }

    public static boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    public static String getValidGraduationRank() {
        String graduationRank;
        do {
            graduationRank = scanner.next();
        } while (!isValidGraduationRankValue(graduationRank));
        return graduationRank;
    }

    public static boolean isValidGraduationRankValue(String graduationRank) {
        return graduationRank.equalsIgnoreCase("Excellence") ||
                graduationRank.equalsIgnoreCase("Good") ||
                graduationRank.equalsIgnoreCase("Fair") ||
                graduationRank.equalsIgnoreCase("Poor");
    }
}
