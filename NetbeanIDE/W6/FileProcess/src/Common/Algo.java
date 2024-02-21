
package Common;

import Model.Person;
import View.View;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Algo {
    
    private final Person model;
    private final View view;
    private final List<Person> personList;

    private final Scanner scanner = new Scanner(System.in);   

    public Algo(Person model, View view) {
        this.model = model;
        this.view = view;
        this.personList = new ArrayList<>();
    }
        public void findPersonInfo() {
        try {
            System.out.println("\n--------- Person info ---------");
            System.out.print("Enter Path:");
            String filePath = scanner.next();

            System.out.print("Enter Money:");
            double minSalary = scanner.nextDouble();
            scanner.nextLine();

            List<Person> personList = getPerson(filePath, minSalary);

            if (personList.isEmpty()) {
                System.out.println("No matching records found.");
            } else {
                view.displayPersonInfo(personList);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input format. Please enter valid numeric values.");
            scanner.next(); // Clear the invalid input from the scanner
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void copyTextToNewFile() {
        try {
            System.out.println("\n------------- Copy text --------------");
            System.out.print("Enter Source:");
            String sourceFilePath = scanner.next();

            System.out.print("Enter new file name:");
            String destinationFilePath = scanner.next();

            boolean success = copyWordOneTimes(sourceFilePath, "d:\\" + destinationFilePath);

            view.displayCopyTextResult(success);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public List<Person> getPerson(String path, double money) throws Exception {
        File file = new File(path);

        if (!file.exists()) {
            throw new Exception("Path doesn't exist");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String name = parts[0];
                    String address = parts[1];
                    double salary = Double.parseDouble(parts[2]);

                    Person person = new Person(name, address, salary);
                    personList.add(person);
                }
            }
        } catch (IOException e) {
            throw new Exception("Can’t read file");
        }

        if (personList.isEmpty()) {
            throw new Exception("No data found in the file.");
        }

        // Sort the list by salary
        Collections.sort(personList, Comparator.comparingDouble(Person::getSalary));

        return personList;
    }

    public boolean copyWordOneTimes(String source, String destination) throws Exception {
        File sourceFile = new File(source);
        File destinationFile = new File(destination);

        if (!sourceFile.exists() || !destinationFile.exists()) {
            throw new Exception("Path doesn't exist");
        }

        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s*\\n\\s*");
                Collections.addAll(words, lineWords);
            }
        } catch (IOException e) {
            throw new Exception("Can’t read file");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new Exception("Can’t write file");
        }

        return true;
    }
}
