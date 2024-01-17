package LAB211.StudentManagement.Controller;

import java.util.*;
import java.text.*;
import java.lang.*;

import LAB211.StudentManagement.Model.*;

public class Control extends ArrayList<Student>{

    final Scanner sc = new Scanner(System.in);
    final List<Student> students = new ArrayList<Student>();

    public void CreateStudent(ArrayList<Student> students) {
        String name, semeter, id, course;
        int count = 0;
        // while (n <= 10){
        //     System.out.print("Enter student name: ");
        //     name = sc.nextLine();
        //     System.out.print("Enter student course: ");
        //     course = sc.nextLine();
        //     Model st = new Model(name, course);
        //     System.out.println("Student " + "" + " had been added");
        //     boolean continueornot;
        //     System.out.println("Do you want to continue?: ");
        //     continueornot = continueornot(sc.nextLine());
        // }

        while (true) {
            System.out.println("Enter student id: ");
            id = sc.nextLine();
            System.out.println("Enter student name: ");
            name = sc.nextLine();
            System.out.println("Enter semeter: ");
            semeter = sc.nextLine();
            System.out.println("Enter course: ");
            course = sc.nextLine();
            Student st = new Student(name, semeter, course, id);
            students.add(st);
        }

        // if (count > 10) {
        //     System.out.println("Continue? (Y/N): ");
        //     if (continueornot(sc.nextLine())){
        //         return;
        //     }
        // }

    }

    public boolean continueornot(String yesorno){
        while (true){
            if (yesorno.equalsIgnoreCase("Y")){
                return true;
            }   
            else if (yesorno.equalsIgnoreCase("N")){
                return false;
            }
        }
    }

    // public void findandsort(ArrayList<Student> students) {
    //     ArrayList<Student> list = new ArrayList<>(students);
    //     Collections.sort((List<T>) list);
    //     for (Student student : list) {
    //         System.out.println(student);
    //     }
    // }

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
}
