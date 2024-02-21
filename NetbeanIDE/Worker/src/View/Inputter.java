
package View;

import java.util.Scanner;

public class Inputter {
    Scanner sc = new Scanner (System.in);
    View view = new View();
    public String inputStr(String mess){
        view.displayToInput(mess);
        return sc.nextLine();
    } 
}
