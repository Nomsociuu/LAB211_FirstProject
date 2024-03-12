
package DAO;

import Model.Obj;
import java.util.ArrayList;

public class ObjDAO {
    private ArrayList<Obj> objs = new ArrayList<>();
    private int nextId = 1;
    public boolean AddObj(Obj obj){
        if(obj !=null){
            obj.setA(nextId++);
            objs.add(obj);
            return true;
        }
        return false;
    }
    
    public ArrayList<Obj> getObj(){
        return new ArrayList<>(objs);
    }
    
    public boolean removeObj(int id){
        return objs.removeIf(obj->obj.getA()==id);
    }
}
