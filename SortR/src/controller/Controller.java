package controller;

import Model.Model;
import View.View;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private final Model model;
    private final SortPart sorting;
    private final View view;

    private List<Model> mode;

    public Controller(Model model, View view, SortPart sorting) {
        this.model = model;
        this.view = view;
        this.sorting = sorting;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            view.displayMenu();
            System.out.print("Enter your choice (0 to exit): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    view.displaySortMenu();
                    System.out.print("Enter your choice (0 to exit): ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            BubbleSort();
                            break;

                        case 2:
                            QuickSort();
                            break;
                    }
                    break;
                case 2:
                    view.displaySearchMenu();
                    System.out.print("Enter your choice (0 to exit): ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            binarySearch();

                        case 2:
                            QuickSort();
                            break;
                    }
                    break;

                case 0:
                    System.out.println("Exiting program....");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

    }

    private void EnterArray() {
        Scanner scanner = new Scanner(System.in);
        int value;

        System.out.print("Enter the number of elements in the array: ");
        int arraySize = scanner.nextInt();
        int[] temp = new int[arraySize]; // Initialize the array

        System.out.println("Enter the value for each position: ");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Value " + i + " : ");
            value = scanner.nextInt();
            temp[i] = value;
        }
        System.out.println("Unsorted array: ");

        model.setSize(arraySize);
        model.setValue(temp);
        view.displayArray(model.getValue()); // Assuming there is a method getArray() in your model class
    }

    private void BubbleSort() {
        EnterArray();

        int[] array = model.getValue();

        int n = array.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);

        System.out.println("Sorted Array (Bubble Sort):");
        view.displayArray(array);
    }

    private void QuickSort() {
        EnterArray();

        int[] array = model.getValue();
        

        sorting.quickSort(array, 0, array.length - 1);

        System.out.println("Sorted Array (Quick Sort):");
        view.displayArray(array);
    }

    public int binarySearch() {
        Scanner sc = new Scanner(System.in);
        BubbleSort();
        
        System.out.print("Enter the number you want to search: ");
        int num = sc.nextInt();
        int[] arr = model.getValue();
       
        
        int m = 0;
        int n = arr.length - 1;

        while (m <= n) {
            int mid = m + (n - m) / 2;

            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                m = mid + 1;
            } else {
                n = mid - 1;
            }
        }

        return -1;
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        SortPart sorting = new SortPart();
        Controller controller = new Controller(model, view, sorting);

        controller.run();
    }
}
