package Controller;

import Model.Student;
import Model.Validate;
import View.Menu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
                    "Display",
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
                displayAllStudents();
            case 6 ->
                System.out.println("Exited. Bye bye");
            default ->
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void readDataFromFile(String filename) throws IOException, ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String studentName = parts[1];
                    int semester = Integer.parseInt(parts[2]);
                    String courseName = parts[3];
                    boolean fa = false;
                    // check validate
                    if (!fa) {
                        Student st = new Student(studentName, semester, courseName, id);
                        std.add(st);
                    } else {
                        System.out.println("Type wrong information format, type again!!!");
                    }
                }
            }
        }
    }

    public void saveDoctorsToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student st : std) {
                writer.println(st.getId() + ","
                        + st.getStudentname() + ","
                        + st.getSemeter()
                        + "," + st.getCourse());

            }
        } catch (IOException e) {
            throw new IOException("Failed to save data to file: " + filename);
        }
    }

    public void displayAllStudents() {
        System.out.println("Student Information:");
        System.out.printf("%-15s%-15s%-15s%-15s%n", "Student ID", "Name", "Semester", "Course");

        for (Student student : std) {
            System.out.printf("%-15s%-15s%-15d%-15s%n",
                    student.getId(), student.getStudentname(), student.getSemeter(), student.getCourse());
        }
    }

    public void createStudent() {
        try {

            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();

            System.out.println("Enter student name: ");
            String name = sc.nextLine();

            System.out.println("Enter course: ");
            String course = sc.nextLine();

            System.out.println("Enter semeter: ");
            int semester = sc.nextInt();

            Student st = new Student(name, semester, course, id);
            std.add(st);

            saveDoctorsToFile("student.txt");
            System.out.println("Doctor added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Availability. Please enter a number.");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    public void FindAndSortStudent() {
        System.out.println("Enter student name or a part of the name: ");
        String searchName = sc.nextLine().toLowerCase();

        List<Student> filteredStudents = new ArrayList<>();
        for (Student a : std) {
            if (a.getStudentname().toLowerCase().contains(searchName)) {
                filteredStudents.add(a);
            }
        }

        if (filteredStudents.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            // Sort the list based on student names
            Collections.sort(filteredStudents, Comparator.comparing(Student::getStudentname));

            // Display sorted student information
            for (Student a : filteredStudents) {
                System.out.println(a.getStudentname() + ", Semester: " + a.getSemeter()
                        + ", Course: " + a.getCourse());
            }
        }
    }

    public void UpdateAndDeleteStudent() {
        System.out.println("Enter student ID to find: ");
        String searchId = sc.nextLine();

        Optional<Student> foundStudent = std.stream()
                .filter(student -> student.getId().equals(searchId))
                .findFirst();

        if (foundStudent.isPresent()) {
            System.out.println("Student found: " + foundStudent.get().getStudentname());
            System.out.println("Do you want to update (U) or delete (D) student?");
            String choice = sc.nextLine().toUpperCase();

            switch (choice) {
                case "U":
                    updateStudent(foundStudent.get());
                    break;
                case "D":
                    std.remove(foundStudent.get());
                    System.out.println("Student deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Student not found.");
        }
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

    public void createStudents() {
        do {
            createStudent();
            System.out.println("Do you want to continue (Y/N)?");
        } while (continueOrNot(sc.nextLine()));
    }

    public void displayReport() {
        Map<String, Map<String, Integer>> studentCourseCounts = new HashMap<>();

        // Count occurrences of each unique combination of student name and course
        for (Student student : std) {
            String studentName = student.getStudentname();
            String course = student.getCourse();

            studentCourseCounts
                    .computeIfAbsent(studentName, k -> new HashMap<>())
                    .merge(course, 1, Integer::sum);
        }

        // Display the report
        System.out.println("Student name | Course | Total of Course");
        for (Map.Entry<String, Map<String, Integer>> entry : studentCourseCounts.entrySet()) {
            String studentName = entry.getKey();

            for (Map.Entry<String, Integer> courseCount : entry.getValue().entrySet()) {
                String course = courseCount.getKey();
                int totalCourses = courseCount.getValue();

                System.out.printf("%-13s | %-6s | %d%n", studentName, course, totalCourses);
            }
        }
    }

    private void updateStudent(Student student) {
        System.out.println("Current student information:");
        System.out.println("Name: " + student.getStudentname());
        System.out.println("Semester: " + student.getSemeter());
        System.out.println("Course: " + student.getCourse());

        System.out.println("Do you want to update the information?");
        System.out.println("Enter Y for Yes, N for No:");
        String updateChoice = sc.nextLine().toUpperCase();

        if (updateChoice.equals("Y")) {
            System.out.println("Enter new information:");

            System.out.print("Enter new name: ");
            String newName = sc.nextLine();
            student.setStudentname(newName);

            System.out.print("Enter new semester: ");
            int newSemester = sc.nextInt();
            student.setSemeter(newSemester);

            sc.nextLine(); // Consume the newline character
            System.out.print("Enter new course: ");
            String newCourse = sc.nextLine();
            student.setCourse(newCourse);

            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("No updates were made.");
        }
    }

    private boolean continueOrNot(String yesOrNo) {
        return yesOrNo.equalsIgnoreCase("Y");
    }
}
