package Controller;

import View.Menu;

import Controller.BMI;
import Controller.Calculator;

public class Control extends Menu{
    final BMI BMICalc = new BMI();
    final Calculator Calc = new Calculator();

    public Control() {
        super("========= Calculator Program =========", new String[] {"Normal Calculator", 
                                                    "BMI Calculator", "Exit"});
    }

    public void execute(int choice)  {
        switch (choice) {
            case 1:
                System.out.println("\n========= Normal Calculator =========");
                Calc.Memory();
                break;
            case 2:
                System.out.println("\n========= BMI Calculator =========");
                BMICalc.Calculate();
                break;
            case 3:
                System.exit(0);
        }
    }

    // public static void main (String args[]) {
    //     Control controller = new Control();
    //     controller.run();
    // }
}
