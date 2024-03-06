
package View;

public class Display {
    public void mainDisplay(){
        System.out.println("===== Analysis String program ====\n" +
                            "2.	exit");
    }
    public void showDetailMenu(String msg){
        System.out.println("---------" + msg + "---------");
    }
    public void show(String msg){
        System.out.println(msg);
    }
}
