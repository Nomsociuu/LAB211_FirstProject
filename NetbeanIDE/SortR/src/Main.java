
import Model.Model;
import View.Menu;
import Controller.Controller;
import Library.SortPart;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kleqing
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Menu view = new Menu();
        SortPart sorting = new SortPart();
        Controller controller = new Controller(model, view, sorting);

        controller.run();
    }
}
