package Controller;

import Util.*;
import View.*;
import Model.*;

import java.util.*;

public class Controller {
    final Utilities util = new Utilities();
    final Display display = new Display();

    public void execute() {
        List<Student> students = util.inputter();
        List<Student> sortedStudents = util.sortStudent(students);
        display.display(sortedStudents);
    }
    

    // public static void main(String[] args) {
    //     new Controller().execute();
    // }
}
