package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Model.*;
import View.*;

public class Control extends Menu{
    private HashMap<Integer, Model> contacts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    final Validation validation = new Validation();

    public Control() {
        super("\n ====Contact====", new String[] {"Add a contact", "Display all contact", "Delete a contact", "Exit"});
    }

    public void execute(int choice) {
        switch (choice) {
            case 1:
                addContact();
                break;
            case 2:
                displayAllContacts();
                break;
            case 3:
                deleteContact();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    private void addContact() {
        // System.out.print("Enter name: ");
        // String name = scanner.nextLine();
        String name = validation.checkString("Enter name: ");
        // System.out.print("Enter group: ");
        // String group = scanner.nextLine();
        String group = validation.checkString("Enter group: ");
        // System.out.print("Enter address: ");
        // String address = scanner.nextLine();
        String address = validation.checkString("Enter address: ");
        // System.out.print("Enter phone: ");
        // String phone = scanner.nextLine();
        String phone = validation.checkPhone("Enter phone: ");

        Model contact = new Model(name, group, address, phone);
        contacts.put(contact.getId(), contact);

        System.out.println("Contact added successfully!");
    }

    private void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.printf("%-4s%-20s%-15s%-15s%-10s%-15s%-15s%n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
            for (Model contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    private void deleteContact() {
        int id;
        try {
            id = validation.checkInt("Enter the ID of the contact to delete: ");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID. Please enter a valid number.");
            return;
        }

        if (contacts.containsKey(id)) {
            contacts.remove(id);
            System.out.println("Contact deleted successfully!");

            HashMap<Integer, Model> updatedContacts = new HashMap<>();
            int newId = 1;
            for (Model contact : contacts.values()) {
                updatedContacts.put(newId++, contact);
            }
            contacts = updatedContacts;
        } else {
            System.out.println("No contact found with the given ID.");
        }
}

}
