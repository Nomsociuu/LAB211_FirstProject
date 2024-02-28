package LAB211.StudentManagement.Model;

public class Model {
    private int coursenumber;
    private String course;
    private String name;

    public Model(String course, String name) {
        this.name = name;
        this.course = course;
        //this.coursenumber = coursenumber;
    }

    public int getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(int coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " | " + course + " | " + coursenumber;
    }
}
