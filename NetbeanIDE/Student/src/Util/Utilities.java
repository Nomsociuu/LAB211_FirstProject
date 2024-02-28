package Util;

import Model.*;
import Common.*;

import java.util.*;

public class Utilities {

    final Validate val = new Validate();
    final StudentComparator comparator = new StudentComparator();
    List<Student> students = new ArrayList<>();

    public List<Student> inputter() {
        boolean breaker = true;
        do {
            String name = val.checkString("Enter name: ");
            String classes = val.checkString("Enter class: ");
            float mark = val.checkFloatLimit("Enter mark: ", 0, 10);
            Student stu = new Student(name, classes, mark);
            students.add(stu);
            String choice = val.confirm("Do you want to continue? (Y/N): ");
            if (choice.equalsIgnoreCase("N")) {
                breaker = false;
            }
        } while (breaker);
        return students;
    }

    public List<Student> sortStudent(List<Student> students) {
        Collections.sort(students, comparator);
        return students; 
    }
    

    // public void displayStudent() {
    //     for (Student stu : students) {
    //         System.out.println(stu);
    //     }
    // }
}
