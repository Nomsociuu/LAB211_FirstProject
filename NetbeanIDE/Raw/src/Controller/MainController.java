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
        super("-----------Managerment-----------", new String[]{"A",
            "B",
            "C",
            "D",
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
                algo.A();
            case 2 ->
                algo.B();
            case 3 ->
                algo.C();
            case 4 ->
                algo.D();
            case 5 ->
                System.exit(0);
        }
    }

}
