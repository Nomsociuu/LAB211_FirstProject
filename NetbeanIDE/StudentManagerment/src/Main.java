
import Controller.Controller;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.readDataFromFile("student.txt");
        } catch (IOException | ParseException e) {
            System.out.println("Error");
        }
        controller.run();
    }
}
//create, update/delete, save/read, display done
// total course , hien thi sau khi 
//find and sort chua xong
//chuyen course tu nhap sang chon choice

