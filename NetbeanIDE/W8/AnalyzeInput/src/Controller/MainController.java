package Controller;

import View.Menu;
import Common.Algo;

public class MainController extends Menu {

    Algo algo;

    public MainController() {
        super("===== Analysis String program ====", new String[]{"Analysis",
            "Exit"});
        algo = new Algo();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
                algo.Analize();
            case 2 ->
                System.exit(0);
        }
    }

}
