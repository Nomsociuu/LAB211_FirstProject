package Library;

import java.util.*;

public class Utilities {

    static final Scanner scan = new Scanner(System.in);

    public int[] arrayIndex(int size) {
        System.out.println("_____Enter array index_____");
        int array[] = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Index " + (i + 1) + ": ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            }
            array[i] = scan.nextInt();
        }
        System.out.println("Unsorted array: " + Arrays.toString(array));
        return array;
    }
    
    public int getPositiveNumber(String prompt) {
        int number;
        do {
            System.out.print(prompt);
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive decimal number.");
                System.out.print(prompt);
                scan.next(); 
            }
            number = scan.nextInt();
        } while (number <= 0);

        return number;
    }
//Sort
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        } else if (high == low) {
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

    public void BubbleSort(int array[]) {
        int n = array.length;
        boolean swap;

        for (int i = 0; i < n - 1; i++) {
            swap = false;

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
                break;
            }
        }
    }
//Search
    public int binarySearch(int[] arr, int value) {
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

    public int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void displaySearchResult(int result, int value) {
        System.out.println("Search number: " + value);
        if (result != -1) {
            System.out.println("The index of value " + value + " in the array is: " + result);
        } else {
            System.out.println("Value " + value + " is not found in the array.");
        }
    }

}
