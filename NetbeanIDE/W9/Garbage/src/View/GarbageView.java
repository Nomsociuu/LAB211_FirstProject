
package View;

import Common.Library;
import Common.Validate;

public class GarbageView {
    private Library l = new Library();
    private Validate v = new Validate();
    public void GarbageMenu(){
        System.out.println("-----Garbage Managerment--------");
        System.out.println("1.Enter amount of garbage: ");
        System.out.println("2.Exit");
    }
    
}
