package Controller;

import View.Menu;
import Common.Validate;
import Common.Algo;
//import Model.x;
import java.util.ArrayList;

public class MainController extends Menu {

    Algo algo;
    Validate vali;
//    ArrayList<Worker> list_w;
//    ArrayList<SalaryHistory> list_s;
//    Worker w;

    public MainController() {
        super("========= Task program =========", new String[]{"Add Task",
            "Delete task",
            "Display Task",
            "Exit"});
        vali = new Validate();
        algo = new Algo(vali);
//        list_w = new ArrayList<>();
//        list_s = new ArrayList<>();
//        w = new Worker();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                try {
                    algo.addTask(vali.getStringFromInput("Enter Requirement Name: "),
                            vali.getStringFromInput("Enter Task Type: "),
                            vali.getStringFromInput("Enter Date: "),
                            vali.getStringFromInput("Enter Plan From: "),
                            vali.getStringFromInput("Enter Plan To: "),
                            vali.getStringFromInput("Enter Assignee: "),
                            vali.getStringFromInput("Enter Reviewer: "));
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());

                }
            }
            case 2 ->
                algo.deleteTask(vali.getStringFromInput("ID: "));
            case 3 ->
                algo.getDataTasks();
            case 4 ->
                System.exit(0);
        }
    }

}
