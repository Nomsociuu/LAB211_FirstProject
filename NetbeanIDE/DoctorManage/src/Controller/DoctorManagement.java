package Controller;

import View.Menu;
import View.Function;

public class DoctorManagement extends Menu {
    
    Function func = new Function();

    public DoctorManagement() {
        super("========= Doctor Management ==========",
                new String[]{"Add Doctor",
                    "Update Doctor",
                    "Delete Doctor",
                    "Search Doctor",
                    "Exit"});
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                func.addDoctor();
            case 2 ->
                func.updateDoctor();
            case 3 ->
                func.deleteDoctor();
            case 4 ->
                func.searchDoctor();
            case 5 ->
                System.out.println("Exited. Bye bye");
            default ->
                System.out.println("Invalid choice. Please try again.");
        }
    }

   

}
