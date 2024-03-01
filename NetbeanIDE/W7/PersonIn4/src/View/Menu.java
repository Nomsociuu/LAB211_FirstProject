package View;

import Model.Person;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("=====Management Person programer=====");
        System.out.println("1. Input person information");
        System.out.println("2. Display person information");
        System.out.println("3. Sort Person array by salary ascending");
        System.out.println("4.Exit");
    }

    public int getUserOption() {
        displayMenu();
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void displayPersonInfo(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Salary: " + person.getSalary());
    }

    public void displayPersonsInfo(Person[] persons) {
        for (Person person : persons) {
            System.out.println("\nInformation of Persons you have entered:");
            displayPersonInfo(person);
        }
    }

    public void displayTopPersonsInfo(Person[] persons, int count) {
        for (int i = 0; i < Math.min(count, persons.length); i++) {
            System.out.println("\nInformation of Persons you have entered:");
            displayPersonInfo(persons[i]);
            System.out.println();
        }
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
    
    public void PrintMess(String mess){
        System.out.println(mess);
    }
}
