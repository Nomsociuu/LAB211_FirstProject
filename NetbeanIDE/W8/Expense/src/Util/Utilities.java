package Util;

import java.util.*;

import Package.*;
import Model.*;

public class Utilities {
    final Validate valid = new Validate();
    final Model models = new Model();

    public void addExpense(ArrayList<Model> mods, int id) {
        String date = valid.checkDate("Enter date: ");
        double number = valid.checkDouble("Enter amount: ");
        String content = valid.checkString("Enter content: ");
        mods.add(new Model(id, date, number, content));
    }

    public void display(ArrayList<Model> mods) {
        if (mods.size() == 0) {
            System.out.println("Empty list!");
        }
        else {
            double total = 0;
            System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
            for (int i = 0; i < mods.size(); i++) {
                System.out.printf("%-7d%-20s%-20.0f%-20s\n", mods.get(i).getID(), mods.get(i).getDate(),
                        mods.get(i).getNumber(), mods.get(i).getContent());
                total += mods.get(i).getNumber();
            }
            System.out.printf("Total: %-20.0f\n", total);
        }
    }

    public void deleteExpense(ArrayList<Model> mods) {
        int id = valid.checkInt("Enter ID: ");
        System.out.println("Enter ID: ");
        if (valid.checkExistID(mods, id) != 1) {
            mods.remove(valid.checkExistID(mods, id));
            System.out.println("Deleted");
            for (int i = id - 1; i < mods.size(); i++) {
                mods.get(i).setID(mods.get(i).getID() - 1);
            }
        }
        else {
            System.out.println("Delete fail");
        }
    }

}

