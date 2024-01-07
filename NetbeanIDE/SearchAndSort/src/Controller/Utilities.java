package Controller;

import Model.*;
import View.*;
import java.util.*;

public class Utilities extends Menu {

    private final Scanner sc = new Scanner(System.in);
    private final Model model = new Model();
    Controller control = new Controller();

    public Utilities() {
        super("---------------------\n" + "Sort and Search Utilities", new String[]{
            "Input Array", "Sort", "Search", "Exit"
        });

    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                int arrsize = control.arraySize();
                int unsortarr[] = control.arrayIndex(arrsize);
                model.setArray(unsortarr);
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

        int schoice = 0;
        do {
            System.out.println("---------------");
            System.out.println("1. Bubble sort");
            System.out.println("2. Quick sort");
            System.out.println("3. Back");
            System.out.print("\nEnter choice: ");
            schoice = sc.nextInt();
            switch (schoice) {
                case 1:
                    int arrbs[] = model.getArray();
                    if (arrbs != null) {
                        control.BubbleSort(arrbs);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    break;
                case 2:
                    int arrqs[] = model.getArray();
                    if (arrqs != null) {
                        control.quickSort(arrqs, 0, arrqs.length - 1);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    break;
                case 3:
                    return;
            }
        } while (schoice > 0 || schoice < 4);
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
                    int arr[] = model.getArray();
                    if (arr != null) {
                        int searchNumber = getPositiveNumber("Enter the number to search: ");
                        int searchResult = linearSearch(arr, searchNumber);
                        System.out.println("Linear Search: ");
                        displaySearchResult(searchResult, searchNumber);
                    } else {
                        System.out.print("Empty array! Please use function \"Input Array\" first.\n");
                        return;
                    }
                    break;
                case 2:
                    int arrb[] = model.getArray();
                    if (arrb != null) {
                        Arrays.sort(arrb);
                        int searchNumber = getPositiveNumber("Enter the number to search: ");
                        int searchResult = binarySearch(arrb, searchNumber);
                        System.out.println("Binary Search: ");
                        displaySearchResult(searchResult, searchNumber);
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

    private int getPositiveNumber(String prompt) {
        int number;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive decimal number.");
                System.out.print(prompt);
                sc.next(); // consume non-integer input
            }
            number = sc.nextInt();
        } while (number <= 0);

        return number;
    }

    private int binarySearch(int[] arr, int value) {
        int m = 0;
        int n = arr.length - 1;

        while (m <= n) {
            int mid = m + (n - m) / 2;

            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                m = mid + 1;
            } else {
                n = mid - 1;
            }
        }

        return -1;
    }

    private int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void displaySearchResult(int result, int value) {
        System.out.println("Search number: " + value);
        if (result != -1) {
            System.out.println("The index of value " + value + " in the array is: " + result);
        } else {
            System.out.println("Value " + value + " is not found in the array.");
        }
    }
}
