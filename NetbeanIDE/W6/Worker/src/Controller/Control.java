package Controller;

import Common.Manager;
import Model.SalaryHistory;
import Model.SalaryStatus;
import Model.Worker;
import View.Menu;
import View.View;
import java.util.ArrayList;

public class Control extends Menu {

    private Manager mg;
    private ArrayList<Worker> listWorker = new ArrayList<>();
    private ArrayList<SalaryHistory> listSalary = new ArrayList<>();
    private Worker worker = null;
    private View view = new View();
    public Control() {
        super("Worker Management", new String[]{"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"});
        mg = new Manager(listWorker, listSalary);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                worker = new Worker();
                try {
                    mg.addWorker(worker);
                } catch (Exception e) {
                    view.displayMess(e.getMessage());
                }
                break;
            case 2:
                mg.changeSalary(SalaryStatus.UP);
                break;
            case 3:
                mg.changeSalary(SalaryStatus.DOWN);
                break;
            case 4:
                mg.getInfomationSalary();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
}
