package View;

import Model.*;

import java.util.*;

public class Display {
    List<Student> students = new ArrayList<Student>();

    public void display(List<Student> students) {
        int studentNumber = 1;
        for (Student student : students) {
            System.out.println("-------------Student " + studentNumber + "-------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Classes: " + student.getClasses());
            System.out.println("Mark: " + student.getMark());
            studentNumber++;
        }
    }
}
