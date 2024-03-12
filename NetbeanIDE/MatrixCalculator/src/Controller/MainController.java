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
        super("=======Calculator program======", new String[]{"Addition Matrix",
            "Subtraction Matrix",
            "Multiplication Matrix",
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
            case 1 ->
                algo.additionMatrix();
            case 2 ->
                algo.subtractionMatrix();
            case 3 ->
                algo.multiplicationMatrix();
            case 4 ->
                System.exit(0);
        }
    }

}
