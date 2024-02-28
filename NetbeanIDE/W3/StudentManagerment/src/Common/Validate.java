package Common;

import Model.Report;
import Model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);
    private static String id;
    
    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {

        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static String getIDString() {
        return id;
    }

    public static boolean isEmpIdValid(String empId) {
        return empId.matches("ST\\d{3}");
    }

    public static boolean validDoc() {
        do {
            id = in.nextLine();
            if (id.matches("ST\\d{3}")) {
                return true;
            } else {
                System.out.println("The Student must follow format 'STxxx' with x is digit");
                System.out.print("Enter Student ID: ");
            }
        } while (true);
    }
 
    public static int checkInputSemester() {
        //loop until user input correct
        while (true) {
            try{
                int result = in.nextInt();
                in.nextLine();
                if (result == 0) {
                    throw new Exception();
                } 
                return result;
            }catch(Exception e){
                System.out.println("Invalid input semester!");
                System.out.print("Enter again: ");
                in.nextLine();
            }
        }
    }
    public static String checkInputName() {
        while (true) {
            String result = in.nextLine().trim();
            String regex ="^[a-zA-Z\\s'-]+$";
            if (result.matches(regex)&& result.length() >= 2) {         
                result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid name without number and at least two character.");
                System.out.print("Enter again: ");
            }
        }
    }
    

    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }else{
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
            }
        }
    }

    //check user input u / d
    public static boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    //check user input course
    public static String checkInputCourse() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //check input coursescjava/ .net/ c/c++
            if (result.equalsIgnoreCase("Java")
                    || result.equalsIgnoreCase(".Net")
                    || result.equalsIgnoreCase("C/C++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    //check student exist
    public static boolean checkStudentExist(ArrayList<Student> students,String id, String studentName, int semester, String courseName) {
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentname())
                    && semester == student.getSemeter()
                    && courseName.equalsIgnoreCase(student.getCourse())) {
                return false;
            }
        }
        return true;
    }

    //check report exist
    public static boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getName())
                    && course.equalsIgnoreCase(report.getCourse())
                    && total == report.getCoursenumber()) {
                return false;
            }
        }
        return true;
    }
    public static String checkInputId() {//test ok
        while (true) {
            String result = in.nextLine().trim();
            String regex ="^[a-zA-Z0-9\\s'-]+$";
            if (result.matches(regex)) {         
                result = result.toUpperCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid ID.");
                System.out.print("Enter again: ");
            }
        }
    }
    //check id and exist
    public static boolean checkIdExist(ArrayList<Student> ls, String id /*String name*/) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId()) /*!name.equalsIgnoreCase(student.getStudentName()*/) {
                return false;
            }
        }
        return true;
    }
    //check user change or not
    public static boolean checkChangeInfomation(Student student, String id,
            String name, int semester, String course) {
        if (id.equalsIgnoreCase(student.getId())
                && name.equalsIgnoreCase(student.getStudentname())
                && semester == student.getSemeter()
                && course.equalsIgnoreCase(student.getCourse())) {
            return false;
        }
        return true;
    }
}
