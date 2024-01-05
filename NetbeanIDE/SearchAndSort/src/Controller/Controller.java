package Controller;

import Model.*;
import View.*;
import java.util.*;

// TODO: Run function from model
// * Function work

public class Controller {
    
    static final Scanner scan = new Scanner(System.in);
    private List<Model> models;

    public Controller() {
        // super("Sort and Search Utilities", new String[] {
        //     "Sort", "Search", "Exit"
        // });
        models = new ArrayList<>();
    }

    // @Override
    // public void execute(int choice) {
    //     switch (choice) {
    //         case 1:
                
    //             break;
    //     }
    // }


    public int arraySize(){
        int size;
        do {
            System.out.print("Enter the size of the array: ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer number.");
                    scan.next();
            }
            size = scan.nextInt();
            if (size <= 0) {
                System.out.println("Invalid input. Please enter a positive integer number.");
            }
        } while (size <= 0);
        return size;
    }
            
    public int[] arrayIndex(int size) {
        // System.out.println();
        // Model arrvalue = new Model (size, array);
        //models.add(arrvalue);
        //System.out.println();
        System.out.println("Enter array index: ");
        int array[] = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Index " + (i + 1) + ": ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next(); 
            }
            array[i] = scan.nextInt();
        }
        // Model mod = new Model(array);
        // models.add(mod);
        System.out.println(Arrays.toString(array));
        return array;
    }

    // private int[] Arrayindex(int size) {
    //     System.out.println("Enter array index: ");
    //     int array[] = new int[size];

    //     for (int i = 0; i < size; i++) {
    //         System.out.print("Index " + (i + 1) + ": ");
    //         while (!scan.hasNextInt()) {
    //             System.out.println("Invalid input. Please enter an integer.");
    //             scan.next(); 
    //         }
    //         array[i] = scan.nextInt();
    //     }
    //     System.out.print(Arrays.toString(array));
    //     return array;
    // }

    // public void displayArray() {
    //     System.out.print(Arrays.toString(array));
    // }

    // public static void main(String[] args) {
    //     Controller controller = new Controller();
    //     controller.run();
    // }

    // public int[] RandomArray(int size) {
    //     int[] array = new int[size];
    //     Random random = new Random();

    //     for (int i = 0; i < size; i++) {
    //         array[i] = random.nextInt(100); 
    //     }

    //     return array;
    // }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            //System.out.println(Arrays.toString(array));
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
        else if (high == low) {
            System.out.println("Array was sorted using Quick sort!");
            System.out.println(Arrays.toString(array));
        }
        
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void BubbleSort(int array[]) {
        int n = array.length;
        boolean swap;

        for (int i = 0; i < n - 1; i++) {
            swap = false;
            // System.out.println("\nCheck value " + (i + 1) + ":");

            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                System.out.println("Array was sorted using Bubble sort!");
                System.out.println(Arrays.toString(array));
                //System.out.println("All array value is sorted!");
                break;
            }
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int m = 0;
        int n = arr.length - 1;

        while (m <= n) {
            int mid = m + (n - m) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
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
    
    // public int Target() {
    //     System.out.print("Enter");
    // }

    public int getSearchTarget() {
        System.out.print("Enter the index value: ");
        return scan.nextInt();
    }

    public void displaySearchResult(int result, int target) {
        if (result != -1) {
            System.out.println("The index " + target + " in array is: " + result);
        } else {
            System.out.println("Index " + target + " is not found in the array.");
        }
    }
}
