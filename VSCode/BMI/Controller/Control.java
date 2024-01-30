package LAB211.BMI.Controller;

import LAB211.BMI.View.Menu;

import LAB211.BMI.Controller.BMI;
import LAB211.BMI.Controller.Calculator;

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
