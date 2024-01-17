package Controller;


import Model.Student;
import View.Menu;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Student> std = new ArrayList<>();
    Menu menu = new Menu();

    public void run() {
        while (true) {
            int choice;
            do {
                menu.displayMainMenu();
                choice = menu.getUserChoice(1, 5);

                switch (choice) {
                    case 1:
                        System.out.println("Create");
                        break;
                    case 2:
                        System.out.println("Find and Sort");
                        break;
                    case 3:
                        System.out.println("Update/Delete");
                        break;
                    case 4:
                        System.out.println("Report");
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        System.exit(0);
                }
            } while (choice > 0 && choice <= 5);

        }
    }

}
