package Controller;

import Utilities.Worker;
import View.*;

public class Controller extends Menu{

    final Worker worker = new Worker();

    public Controller() {
        super("\n====Worker Salary Management====   ", new String[] {"Add worker", "Increase Salary", 
                    "Decrease Salary", "Display salary infomation",
                    "Exit"});
    }

    public void execute(int choice) {
        switch (choice) {
            case 1:
                worker.addWorker();
                break;
            case 2:
                worker.increaseSalary();
                break;
            case 3:
                worker.decreaseSalary();
                break;
            case 4:
                worker.displaySalary();
                break;
            case 5:
                System.exit(0);
        }
    }
}
