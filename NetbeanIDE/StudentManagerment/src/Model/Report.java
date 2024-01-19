package Model;

public class Report {
    private int coursenumber;
    private String course;
    private String name;

    public Report(String course, String name, int coursenumber) {
        this.name = name;
        this.course = course;
        this.coursenumber = coursenumber;
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
