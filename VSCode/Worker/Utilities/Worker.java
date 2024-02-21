package Utilities;

import java.text.SimpleDateFormat;
import java.util.*;

import Model.Model;
import Model.History;
import Common.Validate;

enum Status {
    UP, DOWN
}

public class Worker {
    private ArrayList<Model> workers = new ArrayList<>();
    private ArrayList<History> history = new ArrayList<>();
    final Scanner sc = new Scanner(System.in);
    final Validate validate = new Validate();

    public void addWorker() {
        try {
            Model worker;
            String id;
            do {
                id = validate.checkString("Enter id: ");
                worker = findWorkerById(id);
                if (worker != null) {
                    System.out.println("ID already exists! Please choose a different one.");
                }
            } while (worker != null);
            
            String name = validate.checkString("Enter name: ");
            int age = validate.checkIntLimit("Enter age: ", 0, 100);
            double salary = validate.checkDouble("Enter salary: ");
            String location = validate.checkString("Enter location: ");
            
            worker = new Model(id, name, age, salary, location);
            workers.add(worker);
            System.out.println("Worker added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String inpuut() {
        String filename = validate.checkString("Enter String: ");
        return filename;
    }

    public void increaseSalary() {
        try {
            Model w;
            do {
                w = findID();
                if (w == null) {
                    System.out.print("Not found! Enter a valid ID: ");
                }
            } while (w == null);
            
            double amount = validate.checkDouble("Enter amount: ");
            double oldSalary = w.getSalary();
            double newSalary = oldSalary + amount;
            saveSalary(w, oldSalary, newSalary, "UP");
            System.out.println("Salary increased: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void decreaseSalary() {
        try {
            Model w;
            do {
                w = findID();
                if (w == null) {
                    System.out.print("Not found! Enter a valid ID: ");
                }
            } while (w == null);
            
            double amount = validate.checkDouble("Enter amount: ");
            double oldSalary = w.getSalary();
            double newSalary = oldSalary - amount;
            saveSalary(w, oldSalary, newSalary, "DOWN");
            System.out.println("Salary decreased: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Model findID() {
        String id = validate.checkString("Enter id: ");
        for (Model w : workers) {
            if (w.getID().equalsIgnoreCase(id)) {
                return w;
            }
        }
        return null;
    }

    private void saveSalary(Model worker, double oldSalary, double newSalary, String status) {
        Date date = new Date();
        History hst = new History(worker.getID(), oldSalary, newSalary, status, date);
        history.add(hst);
    }

    public void displaySalary() {
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.printf("%-6s %-10s %-8s %-12s %-12s %-8s %-12s%n", "Code", "Name", "Age", "Old Salary", "New Salary", "Status", "Date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String prevId = null; // To track previous worker ID
        for (History record : history) {
            Model worker = findWorkerById(record.getId());
            if (worker != null) {
                if (!record.getId().equals(prevId) || record.getOldSalary() != record.getNewSalary()) {
                    System.out.printf("%-6s %-10s %-8d %-12.2f %-12.2f", record.getId(), worker.getName(), worker.getAge(), record.getOldSalary());
                } else {
                    // Print empty fields to align with the header
                    System.out.printf("%-40s", "");
                }
                System.out.printf("%-12.2f %-8s %-12s%n", record.getNewSalary(), record.getStatus(), sdf.format(record.getDate()));
                prevId = record.getId();
            }
        }
    }
    
    

    

    private Model findWorkerById(String id) {
        for (Model worker : workers) {
            if (worker.getID().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }
}
