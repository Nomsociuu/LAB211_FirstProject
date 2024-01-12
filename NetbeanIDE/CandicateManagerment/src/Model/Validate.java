package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validate {

    static final Scanner scanner = new Scanner(System.in);

    public String getPhone() {
        String phone;
        do {
            System.out.print("Enter Phone (minimum 10 digits): ");
            phone = scanner.next();
        } while (!phone.matches("\\d{10,}"));
        return phone;
    }

    public String getEmail() {
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
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid input.");
            }
            number = scanner.nextInt();
            scanner.nextLine();
        } while (number < min || number >= max);
        return number;
    }

    public String checkBirthDay() {
        while (true) {
            System.out.print("Enter BirthDay: ");
            String result = scanner.nextLine().trim();
            String regex = "^[0-9]{4}$";
            if (result.matches(regex)) {
                int birthYear = Integer.parseInt(result);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int age = currentYear - birthYear;
                if (birthYear < currentYear && age >= 18 && age <= 60) {
                    return result;
                } else {
                    System.out.println("Invalid input. Birth year cannot be in current or the future and age is from 18 to 60.");
                    System.out.print("Enter again: ");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid birth year with a length of 4 digits.");
                System.out.print("Enter again: ");
            }
        }
    }

//Trong Fresher xet TH BirthD>=GraduationD
    public boolean checkTime(String BirthD, String GraduateD) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy");

            Date birthDate = df.parse(BirthD);
            Date graduationDate = df.parse(GraduateD);

            //tru di 18
            Calendar cal = Calendar.getInstance();
            cal.setTime(birthDate);
            cal.add(Calendar.YEAR, 18);
            Date minBirthDate = cal.getTime();

            return graduationDate.after(minBirthDate) || graduationDate.equals(minBirthDate);
        } catch (ParseException e) {
            return false;
        }

    }
}
