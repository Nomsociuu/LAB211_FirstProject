package Model;

public class Model {
    private static int addID = 0;
    private int ID;
    private String date;
    private double number;
    private String content;

    

    public Model(){}
    public Model(int ID, String date, double number, String content) {
        this.ID = ID;
        this.date = date;
        this.number = number;
        this.content = content;
    }

    public static void setLastID(int id) {
        addID = id;
    }
    
    public int getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public double getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
