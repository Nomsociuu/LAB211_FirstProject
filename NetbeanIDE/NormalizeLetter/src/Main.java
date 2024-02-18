
import Controller.TextController;
import Library.Library;

public class Main {
                                    
    public static void main(String[] args) {
        Library view = new Library();
        TextController controller = new TextController(view);
        controller.run();
    }

}
