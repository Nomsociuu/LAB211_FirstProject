package LAB211.StudentManagement.Controller;

import java.util.*;
import java.text.*;
import java.lang.*;

import LAB211.StudentManagement.Model.*;
import LAB211.StudentManagement.View.*;

public class Control extends Menu{

    public Control() {
        super("STUDENT MANAGEMENT", new String[] {"Create", 
                                                "Find and sort", 
                                                "Update and delete", 
                                                "Report", 
                                                "Exit"});
    }

    final Scanner sc = new Scanner(System.in);
    final List<Student> students = new ArrayList<Student>();
    final Model.Student modelstudent = new Model.Student();
    final View.Validation validation = new View.Validation();

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
            if (!validation.checkIdExists(students, id, name)) {
                System.out.print("Duplicate student. Try again: ");
                continue;
            }
            System.out.println("Enter semeter: ");
            semeter = sc.nextInt();
            System.out.println("Enter course: ");
            course = sc.nextLine();
            Student st = new Student(name, semeter, course, id);
            if (validation.checkStudentExist(st)) {
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

    // public boolean continueornot(String yesorno){
    //     while (true){
    //         if (yesorno.equalsIgnoreCase("Y")){
    //             return true;
    //         }   
    //         else if (yesorno.equalsIgnoreCase("N")){
    //             return false;
    //         }
    //     }
    // }

    // public void findandsort(ArrayList<Student> students) {
    //     ArrayList<Student> list = new ArrayList<>(students);
    //     Collections.sort((List<T>) list);
    //     for (Student student : list) {
    //         System.out.println(student);
    //     }
    // }

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
        return students.get(choice - 1);
    }

    public void updateanddel(int count, ArrayList<Student> students) {
        String id, name, course;
        int semeter;
        System.out.print("Enter id: ");
        id = sc.nextLine();
        ArrayList<Student> listname = new ArrayList<Student>(students, id);

        //ArrayList<Student> listid = listid(students, id);
        if (listname.isEmpty()) {
            System.out.println("No students found");
        }
        else {

            Student studentes = StudentList(listname);
            System.out.println("Update (U) or Delete(D): ");

            if (validation.checkInputUD()) {

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
                if (validation.checkChangeInfomation(st)) {
                    System.out.print("Error while update student");
                }

                if (validation.checkStudentExist(st)) {
                    modelstudent.setId(id);
                    modelstudent.setName(name);
                    modelstudent.setSemeter(semeter);
                    modelstudent.setCourse(course);

                }
            }
            else {
                System.out.println("=   ==Delete student===");
                students.remove(studentes);
                count--;
            }
        }

    }

    @Override
    public void execute(int choice){
        ArrayList<Student> students = new ArrayList<>();
        int count = 10;
        students.add(new Student("1", "asdas", "XD", "JAV"));
        switch (choice) {
            case 1:
                CreateStudent(count, students);
                break;
            case 2:
                findandsort(students);
                break;
            case 3:
                updateanddel(count, students);
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public void main (String[] args) {
        Control con = new Control();
        con.run();
    }
}
