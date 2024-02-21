package Model;

public class Model {
    private String ID;
    private String Name;
    private int Age;
    private double Salary;
    private String Location;

    public Model(){ }
    public Model(String ID, String Name, int Age, double Salary, String Location) {
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.Salary = Salary;
        this.Location = Location;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
}
