package Model;

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

    public String checkString(String ms) {
        System.out.print(ms);
        return sc.nextLine();
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
}
