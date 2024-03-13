
package View;

public class Display {
    public void mainDisplay(){
        System.out.println("========= Task program =========\n" +
                            "1.	Add Task\n" +
                            "2.	Delete task\n" +
                            "3.	Display Task\n" +
                            "4.	exit");
    }
    public void showDetailMenu(String msg){
        System.out.println("---------" + msg + "---------");
    }
    
    public void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print("[" + value + "]");
            }
            System.out.println();
        }
    }
}
