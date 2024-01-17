package Controller;

import Model.Student;
import View.Menu;
import java.io.IOException;
import java.util.*;

public class Controller extends Menu {

    final Scanner sc = new Scanner(System.in);
    List<Student> std = new ArrayList<>();

    public Controller() {
        super("WELCOME TO STUDENT MANAGEMENT \n--------------------------------",
                new String[]{"Create student",
                    "Find and sort student",
                    "Update/Delete student",
                    "Report",
                    "Exit the program"});
        std = new ArrayList<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                createStudent();
            case 2 ->
                FindAndSortStudent();
            case 3 ->
                UpdateAndDeleteStudent();
            case 4 ->
                Report();
            case 5 ->
                System.out.println("Exited. Bye bye");
            default ->
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void createStudent() {
        System.out.println("Enter student id: ");
        String id = sc.nextLine();
        System.out.println("Enter student name: ");
        String name = sc.nextLine();
        System.out.println("Enter semeter: ");
        int semester = sc.nextInt();
        System.out.println("Enter course: ");
        String course = sc.nextLine();
        Student st = new Student(name, semester, course, id);
        std.add(st);
    }

    public void createStudent1() {
        try {
//        String id;
//        boolean codeDup;
//        do {
//            codeDup = false; 
//            System.out.print("Enter Student ID: ");
//            Validate.validDoc();
//            id = String.valueOf(Validate.getIDString());
//            for (std a : stdlist) {
//                if (a.getCode().equalsIgnoreCase(id)) {
//                    System.out.println("Code is duplicated, enter again");
//                    codeDup = true; 
//                    break; 
//                }
//            }
//        } while (codeDup); 

            System.out.println("Enter Student Id: ");
            String id = sc.nextLine();
            
            System.out.println("Enter student name: ");
            String name = sc.nextLine();
            
            System.out.println("Enter semeter: ");
            int semester = sc.nextInt();
            
            System.out.println("Enter course: ");
            String course = sc.nextLine();
            
            Student st = new Student(name, semester, course, id);
            std.add(st);
            
            saveDoctorsToFile("doctor.txt");
            System.out.println("Doctor added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Availability. Please enter a number.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void FindAndSortStudent() {

    }

    public void UpdateAndDeleteStudent() {

    }

    public void Report() {

    }

    public boolean continueornot(String yesorno) {
        while (true) {
            if (yesorno.equalsIgnoreCase("Y")) {
                return true;
            } else if (yesorno.equalsIgnoreCase("N")) {
                return false;
            }
        }
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

    public void createStudents() {
        do {
            createStudent();
            System.out.println("Do you want to continue (Y/N)?");
        } while (continueOrNot(sc.nextLine()));
    }

    public void findAndSortStudent() {
    System.out.println("Enter student name or a part of the name: ");
    String searchName = sc.nextLine().toLowerCase();

    List<Student> filteredStudents = new ArrayList<>();
    for (Student student : students) {
        if (student.getName().toLowerCase().contains(searchName)) {
            filteredStudents.add(student);
        }
    }

    if (filteredStudents.isEmpty()) {
        System.out.println("No matching students found.");
    } else {
        // Sort the list based on student names
        Collections.sort(filteredStudents, Comparator.comparing(Student::getName));

        // Display sorted student information
        for (Student student : filteredStudents) {
            System.out.println(student.getName() + ", Semester: " + student.getSemester() +
                    ", Course: " + student.getCourse());
        }
    }
}


    public void updateAndDeleteStudent() {
        System.out.println("Enter student ID to find: ");
        String searchId = sc.nextLine();

        Optional<Student> foundStudent = students.stream()
                .filter(student -> student.getId().equals(searchId))
                .findFirst();

        if (foundStudent.isPresent()) {
            System.out.println("Student found: " + foundStudent.get().getName());
            System.out.println("Do you want to update (U) or delete (D) student?");
            String choice = sc.nextLine().toUpperCase();

            switch (choice) {
                case "U":
                    updateStudent(foundStudent.get());
                    break;
                case "D":
                    students.remove(foundStudent.get());
                    System.out.println("Student deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayReport() {
        for (Student student : students) {
            System.out.println("Student name: " + student.getName() +
                    ", Course: " + student.getCourse() +
                    ", Total Courses: " + getTotalCourses(student));
        }
    }

    private void updateStudent(Student student) {
        // Add logic for updating student information
        // For example, ask the user for new information and update the student object
    }

    private int getTotalCourses(Student student) {
        // Add logic to calculate the total number of courses for a student
        // For example, return the size of a list containing the courses
        return student.getCourses().size();
    }

    private boolean continueOrNot(String yesOrNo) {
        return yesOrNo.equalsIgnoreCase("Y");
    }
}
}
