// The program allows use to create list of student, update/delete student information. '
// On the other hand, use can search student(s) and sort result by student name

//There are 4 functions in Student Management Screen, as bellow:
//1.	Create: user creates student by inputting information from keyboard. Use has to create at least 10 students, if number of students greater than 10, the program shows a message: Do you want to continue (Y/N)? Choose Y to continue, N to return main screen.
//2.	Find/Sort: Find and list student (by name) and sort by name, it should display: Student name, semester and Course Name. User inputs student name or a part of student name.
//3.	Update/Delete: The program allows user find a student by ID. After finding a student by Id, a question is displayed (Do you want to update (U) or delete (D) student. If user chooses U, the program allows user updating. Choose D for deleting student.
//4.	Report: write a function to display student(s) with total Courses of this student, as: Student name, Course and Total of Course, for example:

package Model;

public class Student {
    String id,studentName,courseName;
    int semester;

    public Student() {
    }

    public Student(String id, String studentName, String courseName, int semester) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.semester = semester; // (There are only three courses: Java, .Net, C/C++). 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
<<<<<<< Updated upstream

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    
    
=======
>>>>>>> Stashed changes
}
