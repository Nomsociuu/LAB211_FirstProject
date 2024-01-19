
package Model;

public class Student {
    private String studentname;
    private int semeter;
    private String course;
    private String id;

    public Student(String studentname, int semeter, String course, String id) {
        this.id = id;
        this.studentname = studentname;
        this.semeter = semeter;
        this.course = course;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }


     public int getSemeter() {
         return semeter;
     }

     public void setSemeter(int semeter) {
         this.semeter = semeter;
     }

     public String getCourse() {
         return course;
     }

     public void setCourse(String course) {
         this.course = course;
     }

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }
    
    
    

}
