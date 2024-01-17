package LAB211.StudentManagement.Controller;

import java.util.*;
import java.text.*;
import java.lang.*;

import LAB211.StudentManagement.Model.*;

public class Control extends ArrayList<Student>{

    final Scanner sc = new Scanner(System.in);
    final List<Student> students = new ArrayList<Student>();
    final Model.Student modelstudent = new Model.Student();
    public void CreateStudent(int count, ArrayList<Student> students) {
        String name, id, course;
        int semeter;
        //int count = 0;
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
            if (!Validation.checkIdExists(students, id, name)) {
                System.out.print("Duplicate student. Try again: ");
                continue;
            }
            System.out.println("Enter semeter: ");
            semeter = sc.nextInt();
            System.out.println("Enter course: ");
            course = sc.nextLine();
            Student st = new Student(name, semeter, course, id);
            if (Validation.checkStudentExist(st)) {
                students.add(st);
                count++;
                System.out.println("Student had been added");
            }
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

    public void findandsort (ArrayList<Student> students) {
        ArrayList<Student> list = list(students);
        if (list.isEmpty()) {
            System.out.println("No students found");
        }
        else {
            Collections.sort((List<T>) list);
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    public ArrayList<Student> listname(ArrayList<Student> students) {
        ArrayList<Student> list = new ArrayList<>();
        System.out.print("Search name: ");
        String name = sc.nextLine();
        for (Student st : students) {
            if (student.getStudentName().equals(name)) {
                list.add(st);
            }
        }
        return list;
    }

    public ArrayList<Student> listid(ArrayList<Student> students, String id) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student st : students) {
            if (st.getId().equals(id)) {
                list.add(st);
            }
        }
        return list;
    }

    public Student StudentList(ArrayList<Student> students) {
        //int count = 1;
        System.out.print("List student: ");
        int count = 1;
        for (Student student : students) {
            modelstudent.getStudentName();
            modelstudent.getSemester();
            modelstudent.getCourse();
            count++;
        }
        System.out.println("Enter student: ");
        int choice = students.size();
        return students;
    }

    public void updateanddel(int count, ArrayList<Student> students) {
        String id, name, course;
        int semeter;
        System.out.print("Enter id: ");
        id = sc.nextLine();

        ArrayList<Student> listid = listid(students, id);

        System.out.println("Update (U) or Delete(D): ");

        if (Validation.checkInputUD()) {
            System.out.println("===Update student===");
            System.out.println("Enter student id: ");
            id = sc.nextLine();
            System.out.println("Enter student name: ");
            name = sc.nextLine();
            System.out.println("Enter semeter: ");
            semeter = sc.nextInt();
            System.out.println("Enter course: ");
            course = sc.nextLine();
            Student st = new Student(name, semeter, course, id);
            if (Validation.checkChangeInfomation(st)) {
                System.out.print("Error while update student");
            }

            if (Validation.checkStudentExist(st)) {
                modelstudent.setId(id);
                modelstudent.setName(name);
                modelstudent.setSemeter(semeter);
                modelstudent.setCourse(course);

            }
        }
        else {
            System.out.println("=   ==Delete student===");
            students.remove(students);
            count--;
        }

    }
}
