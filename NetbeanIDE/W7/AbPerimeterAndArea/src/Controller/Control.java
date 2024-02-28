package Controller;

import Common.Calculate;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.Menu;
import View.View;

public class Control extends Menu {

    private View vi;
    private Calculate mg;

    public Control() {
        super("Calculator Shape Program", new String[]{"Calculate", "Exit"});
        mg = new Calculate();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                Rectangle retangle = mg.inputRectangle();
                Circle circle = mg.inputCircle();
                Triangle trigle = mg.inputTriangle();

                mg.display(circle,trigle,retangle);
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
}
