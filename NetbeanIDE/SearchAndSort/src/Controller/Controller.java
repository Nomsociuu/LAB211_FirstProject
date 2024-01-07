package Controller;

import Model.*;
import java.util.*;

public class Controller {

    static final Scanner scan = new Scanner(System.in);
    private List<Model> models;

    public Controller() {

        models = new ArrayList<>();
    }

    public int arraySize() {
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
        System.out.println("Unsorted array: " + Arrays.toString(array));
        return array;
    }

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

    public static void BubbleSort(int array[]) {
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

}
