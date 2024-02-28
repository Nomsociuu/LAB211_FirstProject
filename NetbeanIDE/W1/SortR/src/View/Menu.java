package View;

public class Menu {

    public void displayMenu() {
        System.out.println("---------------------");
        System.out.println("Main Program Menu:");
        System.out.println("1.Sort");
        System.out.println("2.Search");
        System.out.println("0. Exit");
        System.out.println("---------------------");
    }
    
    public void displaySortMenu() {
        System.out.println("---------------------");
        System.out.println("Sorting Program Menu:");
        System.out.println("1.Bubble Sort");
        System.out.println("2.Quick Sort");
        System.out.println("0. Exit");
        System.out.println("---------------------");
    }
    
    public void displaySearchMenu() {
        System.out.println("---------------------");
        System.out.println("Searching Program Menu:");
        System.out.println("1.Linear Search");
        System.out.println("2.Binary Sear2ch");
        System.out.println("0. Exit");
        System.out.println("---------------------");
    }

    public void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
