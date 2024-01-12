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
        } while (!phone.matches("\\d{10,}"));
        return phone;
    }

    public static String getEmail() {
        String email;
        do {
            System.out.print("Enter Email: ");
            email = scanner.next();
        } while (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
        return email;
    }

    public static String getValidGraduationRank() {
        String graduationRank;
        do {
            graduationRank = scanner.next();
        } while (!(graduationRank.equalsIgnoreCase("Excellence")
                || graduationRank.equalsIgnoreCase("Good")
                || graduationRank.equalsIgnoreCase("Fair")
                || graduationRank.equalsIgnoreCase("Poor")));
        return graduationRank;
    }

//Hàm nhập 1 String không giới hạn , kí tự khác số
    public String getUnliString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!input.matches("[a-zA-Z\\s]+")) {
            System.out.println("Invalid input. Enter character only!!");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    
//Hàm nhập số : min < num < max; 0 < num < 40 ; 0 < num < 4
    public int getNumberInRange(String prompt, int min, int max) {
        int number;
        do {

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid input.");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < min || number >= max);
        return number;
    }
    
//ID : Str, gồm 3 số
    public String getValidID(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();

        while (!input.matches("DE\\d{3}")) {
            System.out.println("Invalid ID format. Please enter in the format DE###.");
            System.out.print(prompt);
            input = scanner.nextLine();
        }

        return input;
    }

}
