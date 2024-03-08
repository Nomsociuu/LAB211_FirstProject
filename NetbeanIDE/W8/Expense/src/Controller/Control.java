package Controller;

import java.util.ArrayList;

import View.*;
import Util.*;
import Model.*;

public class Control extends Menu{
    ArrayList<Model> mods = new ArrayList<>();
    public Control() {
        super("\n====Handy Expense====", new String[] {
            "Add an expense", "Display all expenses", "Remove an expense", "Exit"
        });
    }

    public void execute(int choice) {
        int id = 0;
        switch (choice) {
            case 1:
                new Utilities().addExpense(mods, ++id);
                break;
            case 2:
                new Utilities().display(mods);
                break;
            case 3:
                new Utilities().deleteExpense(mods);
                id--;
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
