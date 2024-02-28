package Controller;
import View.View;
import java.util.Scanner;

public class Controller {

    private View view;

    public Controller(View view) {
        this.view = view;
    }
    

    public void runCalculator() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMainMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    view.normalCalculator();
                    break;
                case 2:
                    view.bmiCalculator();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    
}
