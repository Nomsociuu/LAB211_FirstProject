package Controller;

import Common.*;

public class ObjController {

    private ObjView view;
    private ObjDAO dao;
    
    public ObjController(ObjDAO dao, ObjView view) {
        this.dao = dao;
        this.view = view;
    }

    public void A() {
        Obj obj = view.getObjDetails();
        if(dao.A(obj)){
            view.displayMessage("Obj added succesfully");
        }
        else{
            view.displayMessage("Failed to add Obj...");
        }
    }

    public void B() {
        view.displayObj(dao.getObj());
    }

    public void C() {
        int id = view.getObjbyId();
        if(dao.removeObj(id)){
            view.displayMessage("Obj removed succesfully");
        }
        else{
            view.displayMessage("Obj removed failed...");
        }
    }


}
