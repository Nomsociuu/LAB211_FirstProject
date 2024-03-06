package Validator.Controller;

import Validator.Common.Validate;
import Validator.View.Inputter;
import Validator.Model.*;

public class Controller {

    final Validate validate = new Validate();
    final Inputter input = new Inputter();
    final Model model = new Model();

    public void runner() {
        Model model = input.inputter();
        display(model);
    }

    public void display(Model model) {
        System.out.println("\n-------DATA FORMAT-------");
        System.out.println("Phone: " + model.getPhone());
        System.out.println("Email: " + model.getEmail());
        System.out.println("Date: " + model.getDate());
    }

    public void execute() {
        runner();
    }
}
