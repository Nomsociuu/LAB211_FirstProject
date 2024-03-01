package View;

import Utilities.Runner;
import Model.*;
import Common.*;

public class Display {
    final Runner run = new Runner();
    final Model model = new Model();
    final Validate validate = new Validate();

    public void input() {
        String file = validate.checkString("Enter path: ");
        model.setPath(file);
        run.execute(file);
    }

}
