package Controller;

import Common.Validation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Model.*;
import View.*;
import Library.*;

public class Control extends Menu{
    private HashMap<Integer, Model> contacts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    final Validation validation = new Validation();
    final Library lib = new Library();

    public Control() {
        super("\n ====Contact====", new String[] {"Add a contact", "Display all contact", "Delete a contact", "Exit"});
    }

    public void execute(int choice) {
        switch (choice) {
            case 1:
                lib.addContact();
                break;
            case 2:
                lib.displayAllContacts();
                break;
            case 3:
                lib.deleteContact();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
