package Common;

import Model.SalaryHistory;
import Model.SalaryStatus;
import Model.Worker;
import View.View;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Manager{
    private ArrayList<Worker> listWorker = new ArrayList<>();
    private ArrayList<SalaryHistory> listSalary = new ArrayList<>();

    public Manager(ArrayList<Worker> listWorker, ArrayList<SalaryHistory> listSalary) {
        this.listWorker = listWorker;
        this.listSalary = listSalary;
    }
    Validation vd = new Validation();
    View view = new View();
    public boolean addWorker(Worker worker) throws Exception{
        view.displayMess("--------- Add Worker ----------");
        do {
            try{
                String id = vd.getID("Enter Code: ");
                String checkedId = vd.isCodeExist(listWorker, id);
                worker.setId(checkedId);
                break;
            }catch(Exception e){
                view.displayMess(e.getMessage());
            }
        } while (true);
        do {
            try{
                String name = vd.getNonBlankStr("Enter Name: ");
                worker.setName(name);
                break;
            }catch(Exception e){
                view.displayMess(e.getMessage());
            }
        } while (true);
        do {
            try{
                int birthYear = vd.getWorkerBirth("Enter Birth Year: ");
                worker.setAge(birthYear);
                break;
            }catch(Exception e){
                view.displayMess(e.getMessage());
            }
        } while (true);
        do {
            try{
                double salary = vd.getWorkerSalary("Enter Salary: ");
                worker.setSalary(salary);
                break;
            }catch(Exception e){
                view.displayMess(e.getMessage());
            }
        } while (true);
        do {
            try{
                String workLocation = vd.getNonBlankStr("Enter work location: ");
                worker.setWorkLocation(workLocation);
                break;
            }catch(Exception e){
                view.displayMess(e.getMessage());
            }
        } while (true);
        return listWorker.add(worker);
    }
    public void changeSalary(SalaryStatus status) {
        System.out.println("------------------------Up/Down Salary-----------------------------");
        String code;
        double salary;
        do {
            try {
                code = vd.getID("Enter Code: ");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        do {
            try {
                salary = vd.getWorkerSalary("Enter Amount: ");
                break;
            } catch (Exception e) {
                view.displayMess(e.getMessage());
            }
        } while (true);

        changeSalary1(status, code, salary);
    }
    private boolean changeSalary1(SalaryStatus status, String code, double amount){
        String defaultDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        view.displayMess("Current Date: "+defaultDate);
        String date = vd.getDate("Enter Date Change Salary(Default is current Date): ");
        Worker worker = vd.findWorker(listWorker, code.toUpperCase());
        if (worker == null) {
            System.out.println("Not Found!");
            return false;
        }
        if (amount > worker.getSalary() && status == SalaryStatus.DOWN) {
            System.out.println("Amout to decrease can not larger than salary ");
            return false;
        }
        switch (status) {
            case UP:
                worker.setSalary(worker.getSalary() + amount);
                return listSalary.add(new SalaryHistory(code, worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation(), SalaryStatus.UP.toString(), date));
            case DOWN:
                worker.setSalary(worker.getSalary() - amount);
                return listSalary.add(new SalaryHistory(code, worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation(), SalaryStatus.DOWN.toString(), date));
        }
        return false;
    }
    public ArrayList<SalaryHistory> getInfomationSalary() {
        if (listSalary.isEmpty()) {
            view.displayMess("There are no information to display\n");
            return listSalary;
        }
        Collections.sort(listSalary);
        view.displayMess("--------------------Display Information Salary-----------------------\n");
        System.out.printf("%-10s %-20s %-10s %-20s %-20s %-10s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (SalaryHistory x : listSalary) {
            x.display();
        }
        return listSalary;
    }
}