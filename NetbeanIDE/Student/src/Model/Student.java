package Model;

public class Student {
    private String name;
    private float mark;
    private String classes;

    public Student() {}
    public Student(String name, String classes, float mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    // @Override
    // public String toString() {
    //     return "Name: " + name + "\nClass: " + classes + "\nMark: " + mark;
    // }
}
