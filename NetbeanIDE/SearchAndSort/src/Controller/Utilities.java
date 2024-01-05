package Controller;

import Model.*;
import View.*;
// import LAB211.SortAndSearch.Model.*;

//TODO: Create menu to display the function
// !Err: can't add arr[] to arr[] value in model

import java.util.*;

public class Utilities extends Menu{
    private final Scanner sc = new Scanner(System.in);
    private final Model model = new Model();
    Controller control = new Controller();
    public Utilities() {
        super("Sort and Search Utilities", new String[] {
            "Input Array", "Sort", "Search", "Exit"
        });
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                int arrsize = control.arraySize();
                int arr[] = control.arrayIndex(arrsize);
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
        Utilities util = new Utilities();
        util.run();
    }

    public void DisplaySortMenu() {
        // System.out.println("1. Input Array");
        

        int schoice = 0;
        do{
            System.out.println("1. Bubble sort");
            System.out.println("2. Quick sort");
            System.out.println("3. Back");
            System.out.print("\nEnter choice: ");
            schoice = sc.nextInt();
            switch (schoice) {
                    // case 1:
                    //     Array();

                    //     ArrayInput();
                    //     break;
                case 1:
                    int arrbs[] = model.getArray();
                    if (arrbs != null) {
                        control.BubbleSort(arrbs);
                    }
                    else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    // int arr[] = mod.getArray();
                    //int arr[] = mod.getArray();
                    //BubbleSort(arr);
                    break;
                case 2:
                    int arrqs[] = model.getArray();
                    if (arrqs != null) {
                        control.quickSort(arrqs, 0, arrqs.length - 1);
                    }
                    else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                        //quickSort(models.get(0).getValue(), 0, models.get(0).getValue().length - 1);
                    break;
                case 3:
                    return;
            }
        }
        while (schoice > 0 || schoice  < 4);
    }

    public void DisplaySearcMenu() {
        int choice;
        do {
            System.out.println("1. Linear seach");
            System.out.println("2. Binary search");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int arrl[] = model.getArray();
                    if (arrl != null) {
                    //int target;
                    //control.BubbleSort(arr);
                        int targetl = control.getSearchTarget();
                        control.linearSearch(arrl, targetl);
                        int resultl = arrl[targetl];
                        control.displaySearchResult(resultl, targetl);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    break;
                case 2:
                    int arrb[] = model.getArray();
                    if (arrb != null) {
                        int targetb = control.getSearchTarget();
                        control.binarySearch(arrb, targetb);
                        int resultb = arrb[targetb];
                        control.displaySearchResult(resultb, targetb);
                    }
                    else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    break;
                case 3:
                    return;
            }
        }
        while (choice > 0 || choice  < 4);
    }
}
