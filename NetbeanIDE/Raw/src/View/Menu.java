
package View;

import java.util.ArrayList;

import Common.Validate;

public abstract class Menu<T> {

    String title;
    ArrayList<T> choice;
    Validate vali = new Validate();

    public Menu() {
        choice = new ArrayList<>();
    }

    public Menu(String t, String[] c) {
        title = t;
        choice = new ArrayList<>();
        for (String s : c) {
            choice.add((T) s);
        }
    }

    public void display() {
        System.out.println(this.title);
        for (int i = 0; i < choice.size(); i++) {
            System.out.println((i + 1) + ". " + choice.get(i));
        }
    }

    public int getChoice() {
        display();
        return vali.getIntInRange("Enter your choice", 1, choice.size() + 1);
    }

    public abstract void execute(int n);

    public void run() {
        while (true) {
            int n = getChoice();
            execute(n);
            if (n > choice.size()) {
                break;
            }
        }
    }
}
