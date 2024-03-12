
package View;

public class ObjView {
    private Library l = new Library();
    private Validate v = new Validate();
    public void ObjMenu(){
        System.out.println("-----Managerment--------");
        System.out.println("1.");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("4.Exit");
    }
    
    public Obj getObjDetails(){
        //Hàm nhận tất cả giá trị của thuộc tính của obj : hàm get để nhập - hàm check để ktra valid - setter để lưu giá trị
        Obj obj = new Obj();
        
        double a = l.getDouble("Enter a: ");
        if(!v.checkPositiveNum(a)){
            System.out.println("A must be greater than 0");
            return null;
        }
        obj.setA(a);
        
        return obj;
    }
    
    public void displayObj(ArrayList <Obj> objs ){
        System.out.println("\nA\nB\nC\nD"); //A,B,C,D là thuộc tính của obj
        for ( Obj o : objs ){
            System.out.println(o.getA()+"\t"+o.getB())+"\t"+o.getC()+"\t"+o.getD());
        }
    }
    
    public void displayMessage(String mes){
        System.out.println(mes);
    }
}
