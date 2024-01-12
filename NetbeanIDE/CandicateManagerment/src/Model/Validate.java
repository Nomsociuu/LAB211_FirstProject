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

    public String getStringUnli(String prompt) {
        String str;
        boolean check = true;
        do {
            System.out.print(prompt);

            while (!scanner.hasNextLine()) {
                System.out.print(prompt);
                scanner.next();
            }

            str = scanner.nextLine();

            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    check = false;
                    break;
                }
            }
        } while (!check);

        return str;
    }
}
