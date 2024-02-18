package Controller;

import Library.Utilities;
import Model.*;
import View.*;
import java.util.*;

public class Control extends Menu {

    private final Scanner sc = new Scanner(System.in);

    private final Model model = new Model();
    private final Utilities control = new Utilities();

    public Control() {
        super("""
              ---------------------
              Sort and Search Utilities""", new String[]{
            "Input Array", "Sort", "Search", "Exit"
        });

    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                model.setSize(control.getPositiveNumber("Enter array size: "));
                int arr[] = control.arrayIndex(model.getSize());
                model.setArray(arr);
                break;
            case 2:
                DisplaySortMenu();
                break;
            case 3:
                DisplaySearcMenu();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public void runner() {
        Control util = new Control();
        util.run();
    }

    public void DisplaySortMenu() {

        int choice = 0;
        do {
            System.out.print("""
                               ---------------------
                               Sort Menu: 
                               1. Bubble sort
                               2. Quick sort
                               3. Back
                               ---------------------
                               Enter choice:  """);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int arrBs[] = model.getArray();
                    if (arrBs != null) {
                        control.BubbleSort(arrBs);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }

                    break;
                case 2:
                    int arrQs[] = model.getArray();
                    if (arrQs != null) {
                        control.quickSort(arrQs, 0, arrQs.length - 1);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    break;
                case 3:
                    return;
            }
        } while (choice > 0 || choice < 4);
    }

    public void DisplaySearcMenu() {
        int choice;
        do {
            System.out.print("""
                               ---------------------
                               Search Menu: 
                               1. Linear Search
                               2. Binary Search
                               3. Back
                               ---------------------
                               Enter choice:  """);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int arrLs[] = model.getArray();
                    if (arrLs != null) {
                        int searchNumber = control.getPositiveNumber("Enter the number to search: ");
                        int searchResult = control.linearSearch(arrLs, searchNumber);
                        System.out.println("Unsorted array: " + Arrays.toString(arrLs));
                        System.out.println("____Linear Search:____");
                        control.displaySearchResult(searchResult, searchNumber);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    break;
                case 2:
                    int arrBs[] = model.getArray();
                    if (arrBs != null) {
                        Arrays.sort(arrBs);
                        int searchNumber = control.getPositiveNumber("Enter the number to search: ");
                        int searchResult = control.binarySearch(arrBs, searchNumber);
                        System.out.println("____Binary Search____");
                        control.displaySearchResult(searchResult, searchNumber);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }

                    break;
                case 3:
                    return;
            }
        } while (choice > 0 || choice < 4);
    }

}
