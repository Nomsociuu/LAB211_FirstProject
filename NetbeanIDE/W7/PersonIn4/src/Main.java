
import Controller.Controller;
import View.Menu;

public class Main {
    public static void main(String[] args) {
        Menu view = new Menu();
        Controller controller = new Controller();
        while (true) {
            int option = view.getUserOption();
            controller.processUserOption(option);
        }
    }
}