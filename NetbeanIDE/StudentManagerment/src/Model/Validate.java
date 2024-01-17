package Model;

import java.util.ArrayList;
import java.util.Scanner;


public class Validate {
//    private final static Scanner in = new Scanner(System.in);
//
//    //check user input number limit
//    public static int checkInputIntLimit(int min, int max) {
//        //loop until user input correct
//        while (true) {
//            try {
//                int result = Integer.parseInt(in.nextLine().trim());
//                if (result < min || result > max) {
//                    throw new NumberFormatException();
//
//                }
//                return result;
//            } catch (NumberFormatException e) {
//                System.err.println("Please input number in rage [" + min + ", " + max + "]");
//                System.out.print("Enter again: ");
//            }
//        }
//    }
//
//    //check user input string
//    public static String checkInputString() {
//        //loop until user input correct
//        while (true) {
//            String result = in.nextLine().trim();
//            if (result.isEmpty()) {
//                System.err.println("Not empty");
//                System.out.print("Enter again: ");
//            } else {
//                return result;
//            }
//        }
//    }
//
//    //check user input yes/ no
//    public static boolean checkInputYN() {
//        //loop until user input correct
//        while (true) {
//            String result = checkInputString();
//            //return true if user input y/Y
//            if (result.equalsIgnoreCase("Y")) {
//                return true;
//            }
//            //return false if user input n/N
//            if (result.equalsIgnoreCase("N")) {
//                return false;
//            }
//            System.err.println("Please input y/Y or n/N.");
//            System.out.print("Enter again: ");
//        }
//    }
//
//    //check user input u / d
//    public static boolean checkInputUD() {
//        //loop until user input correct
//        while (true) {
//            String result = checkInputString();
//            //return true if user input u/U
//            if (result.equalsIgnoreCase("U")) {
//                return true;
//            }
//            //return false if user input d/D
//            if (result.equalsIgnoreCase("D")) {
//                return false;
//            }
//            System.err.println("Please input u/U or d/D.");
//            System.out.print("Enter again: ");
//        }
//    }
//
//    //check user input course
//    public static String checkInputCourse() {
//        //loop until user input correct
//        while (true) {
//            String result = checkInputString();
//            //check input course in java/ .net/ c/c++
//            if (result.equalsIgnoreCase("java")
//                    || result.equalsIgnoreCase(".net")
//                    || result.equalsIgnoreCase("c/c++")) {
//                return result;
//            }
//            System.err.println("There are only three courses: Java, .Net, C/C++");
//            System.out.print("Enter again: ");
//        }
//    }
//
//    //check student exist
//    public static boolean checkStudentExist(ArrayList<Student> ls, String id,
//            String studentName, String semester, String courseName) {
//        int size = ls.size();
//        for (Student student : ls) {
//            if (id.equalsIgnoreCase(student.getId())
//                    && studentName.equalsIgnoreCase(student.getStudentname())
//                    && semester.equalsIgnoreCase(student.getSemeter())
//                    && courseName.equalsIgnoreCase(student.getCourse())) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    //check report exist
//    public static boolean checkReportExist(ArrayList<Report> lr, String name,
//            String course, int total) {
//        for (Report report : lr) {
//            if (name.equalsIgnoreCase(report.getName())
//                    && course.equalsIgnoreCase(report.getCourse())
//                    && total == report.getCoursenumber()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    //check id and exist
//    public static boolean checkIdExist(ArrayList<Student> ls, String id, String name) {
//        for (Student student : ls) {
//            if (id.equalsIgnoreCase(student.getId())
//                    && !name.equalsIgnoreCase(student.getStudentname())) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    //check user change or not
//    public static boolean checkChangeInfomation(Student student, String id,
//            String name, String semester, String course) {
//        if (id.equalsIgnoreCase(student.getId())
//                && name.equalsIgnoreCase(student.getStudentname())
//                && semester.equalsIgnoreCase(student.getSemeter())
//                && course.equalsIgnoreCase(student.getCourse())) {
//            return false;
//        }
//        return true;
//    }
    
    
    private static final Scanner scanner = new Scanner(System.in);
    private static String empId;
    
    public static String getIDString(){
        return empId;
    }

    public static boolean isEmpIdValid(String empId) {
        return empId.matches("ST\\d{3}");
    }
    public static boolean validDoc() {
        do {
            empId = scanner.nextLine();
            if (empId.matches("ST\\d{3}")) {
                return true; 
            } else {
                System.out.println("The Doctor not null and must follow format 'DTxxx' with x is digit");
                System.out.print("Enter Doctor ID: ");
            }
        } while (true);
    }
}