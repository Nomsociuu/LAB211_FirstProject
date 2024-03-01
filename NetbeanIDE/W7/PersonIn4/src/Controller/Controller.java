package Controller;

import Common.Algo;
import Common.Vali;
import Model.Person;
import View.Menu;

public class Controller {

    Person[] persons = new Person[3];
    Menu view = new Menu();
    Algo al = new Algo(persons, view);

    public Controller() {
    }

    public void processUserOption(int option) {

        switch (option) {
            case 1:
                al.inputPersonInfo();
                break;
            case 2:
                al.displayPersonInfo();
                break;
            case 3:
                al.displayTopPersonsInformation(3);
                break;
            case 4:
                System.out.println("Exiting program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

}
