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

    public static String getUnliString() {
        System.out.print("Enter a string (alphabetic characters only, press Enter to finish): ");
        String input = scanner.nextLine();
        while (!input.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input. Please enter alphabetic characters only.");
            System.out.print("Enter a string (alphabetic characters only, press Enter to finish): ");
            input = scanner.nextLine();
        }
        return input;
    }

    
//Hàm nhập số : min < num < max; 0 < num < 40 ; 0 < num < 4
    public static int getNumberInRange(int min, int max) {
        int number;
        do {

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid input.");
                scanner.next(); // Consume invalid input
            }
            number = scanner.nextInt();
        } while (number < min || number >= max);
        return number;
    }
    
//Hàm nhập ngày : Format SimpleDate //DaiTuong
//Hàm nhập string gồm 10 kí tự số // -> Phone
//Hàm nhập email ( available )
// Hàm nhập RankGraduation : choice -> table ( available )

}
