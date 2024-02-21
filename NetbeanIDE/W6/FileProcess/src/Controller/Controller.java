package Controller;

import Common.Algo;
import Model.Person;
import View.View;


public class Controller {
    Person per =new Person();
    View view = new View();

    public Controller() {
    }
    
    Algo al = new Algo(per,view);

    public void processUserOption(int option) {

        switch (option) {
            case 1:
                al.findPersonInfo();
                break;
            case 2:
                al.copyTextToNewFile();
                break;
            case 3:
                System.out.println("Exiting program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
