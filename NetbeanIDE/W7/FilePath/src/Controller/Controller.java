package Controller;

import View.*;
import Utilities.*;

import java.util.*;

public class Controller {
    Display display = new Display();
    Runner runner = new Runner();

    public void result() {
        System.out.println("----- Result Analysis -----");
        display.input();
    }
}
