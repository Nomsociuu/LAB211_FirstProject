package Common;

import java.util.Scanner;

public class Vali {

    Scanner scanner = new Scanner(System.in);

    public String checkName() {
        System.out.print("Please input name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String checkAdd() {
        System.out.print("Please input name: ");
        String address = scanner.nextLine();
        return address;
    }

    public double checkSa() {
        double parsedSalary;
        while (true) {
            System.out.print("Please input salary: ");
            String sSalary = scanner.nextLine();
            parsedSalary = Double.parseDouble(sSalary);

            try {            
                if (parsedSalary <= 0) {
                    throw new Exception("Salary must be greater than zero.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("You must input digit.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return parsedSalary;
    }
}
