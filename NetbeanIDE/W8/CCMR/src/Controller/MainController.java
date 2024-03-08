package Controller;

import View.Menu;
import Common.Validate;
import Common.Algo;
import View.Display;

public class MainController extends Menu {

    Algo algo;
    Validate vali;
    Display dis;

    public MainController() {
        super("========= Task program =========", new String[]{"Add Task",
            "Delete task",
            "Display Task",
            "Exit"});
        vali = new Validate();
        algo = new Algo(vali);
        dis = new Display();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                try {
                    dis.showDetailMenu("Add Task");
                    algo.addTask(vali.getAlphabelticStringFromInput("Enter Requirement Name: "),
                            vali.inputPattern("Enter Task Type: ", "\\d+" ),
                            vali.inputPattern("Enter Date: ", "^\\d{2}-\\d{2}-\\d{4}$" ),
                            vali.inputPattern("Enter Plan From: ", "\\d+\\.\\d+" ),
                            vali.inputPattern("Enter Plan To: ", "\\d+\\.\\d+" ), 
                            vali.getAlphabelticStringFromInput("Enter Assignee: "),
                            vali.getAlphabelticStringFromInput("Enter Reviewer: "));
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());

                }
            }
            case 2 -> {
                try {
                    algo.deleteTask(vali.getStringFromInput("ID: "));
                } catch (Exception e) {
                    System.out.println("Error deleting task: " + e.getMessage());
                }
            }
            case 3 ->
                algo.getDataTasks();
            case 4 ->
                System.exit(0);
        }
    }

}
