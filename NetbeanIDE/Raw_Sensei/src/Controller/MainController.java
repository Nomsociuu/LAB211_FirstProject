package Controller;

import Common.Library;
import View.Menu;
import Common.Validate;
import DataAccess.ObjDAO;
import View.ObjView;
//import Model.x;

public class MainController extends Menu {

    Library l;
    Validate vali;
    ObjDAO dao = new ObjDAO();
    ObjView view = new ObjView();
    ObjController controller;

    public MainController() {
        super("-----------Managerment-----------", new String[]{"A",
            "B",
            "C",
            "D",
            "Exit"});
        vali = new Validate();
        l = new Library();
        controller = new ObjController(dao, view);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
                controller.A();
            case 2 ->
                controller.B();
            case 3 ->
                controller.C();
            case 4 ->
                System.exit(0);
        }
    }

}
