
import Controller.TextController;
import Model.TextModel;
import View.TextView;

public class Main {

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        // Create instances of model, view, and controller
        TextModel model = new TextModel(inputFileName, outputFileName);
        TextView view = new TextView();
        TextController controller = new TextController(model, view);

        // Process text
        controller.processText();
    }
}
