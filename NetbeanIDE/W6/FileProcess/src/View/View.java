package View;

import Model.Person;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    
    public void displayMenu() {

            
        System.out.println("========== File Processing =========");
        System.out.println("1. Find person info");
        System.out.println("2. Copy Text to new file");
        System.out.println("3. Exit");
    }

    public int getUserOption() {
        displayMenu();
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void displayPersonInfo(List<Person> people) {
        System.out.println("\n------------- Result ----------");
        System.out.printf("%-10s%-10s%-10s%n", "Name", "Address", "Money");

        for (Person person : people) {
            System.out.printf("%-10s%-10s%-10.2f%n", person.getName(), person.getAddress(), person.getSalary());
        }

        if (!people.isEmpty()) {
            System.out.println("\nMax: " + people.get(people.size() - 1).getName());
            System.out.println("Min: " + people.get(0).getName());
        }
    }

    public void displayCopyTextResult(boolean success) {
        if (success) {
            System.out.println("Copy done...");
        } else {
            System.out.println("Failed to copy words.");
        }
    }
}
