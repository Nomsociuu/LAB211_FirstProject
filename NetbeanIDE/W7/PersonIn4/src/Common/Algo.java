package Common;

import Model.Person;
import View.Menu;
import java.util.Scanner;

public class Algo {

    private Person[] persons;
    private Menu view;
    private Scanner scanner;

    public Algo(Person[] persons, Menu view) {
        this.persons = persons;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void inputPersonInfo() {
        try {
            for (int i = 0; i < persons.length; i++) {
                System.out.println("Input Information of Person " + (i + 1));
                System.out.print("Please input name: ");
                String name = scanner.nextLine();
                System.out.print("Please input address: ");
                String address = scanner.nextLine();

                while (true) {
                    System.out.print("Please input salary: ");
                    String sSalary = scanner.nextLine();

                    try {
                        double parsedSalary = Double.parseDouble(sSalary);
                        if (parsedSalary <= 0) {
                            throw new Exception("Salary must be greater than zero.");
                        }
                        persons[i] = new Person(name, address, parsedSalary);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("You must input digit.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }

    public void displayPersonInfo() {
        view.displayPersonsInfo(persons);
    }

    public void displayTopPersonsInformation(int count) {
        try {
            persons = new Person().sortBySalary(persons);
            view.displayTopPersonsInfo(persons, count);
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }

    public Person[] sortBySalary(Person[] persons) throws Exception {
        if (persons == null || persons.length == 0) {
            throw new Exception("Can't Sort Person");
        }

        int n = persons.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (persons[i - 1].getSalary() > persons[i].getSalary()) {

                    Person temp = persons[i - 1];
                    persons[i - 1] = persons[i];
                    persons[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        return persons;
    }
}
