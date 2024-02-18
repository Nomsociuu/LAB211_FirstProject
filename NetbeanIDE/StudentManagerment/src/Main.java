
import View.Manage;
import Controller.Control;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Manage mng = new Manage();
        Control control = new Control();
        try {
            mng.readDataFromFile("student.txt");
        } catch (IOException | ParseException e) {
            System.out.println("Error");
        }
        control.run();
    }
}

