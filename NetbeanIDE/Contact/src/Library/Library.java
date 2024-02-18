/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import Model.Model;
import java.util.HashMap;

import Common.Validation;
import java.util.Scanner;
/**
 *
 * @author kleqing
 */
public class Library {
    final Validation validation = new Validation();
    private HashMap<Integer, Model> contacts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    
     public void addContact() {
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

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.printf("%-4s%-20s%-15s%-15s%-10s%-15s%-15s%n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
            for (Model contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact() {
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
