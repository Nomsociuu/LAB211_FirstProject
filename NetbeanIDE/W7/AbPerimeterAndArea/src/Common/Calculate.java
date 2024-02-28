package Common;

import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.View;

public class Calculate {

    View view = new View();
    Validation vd = new Validation();

    public Triangle inputTriangle() {
        while (true) {
            double a = vd.checkInputDouble("Please input side A of Triangle: ");
            double b = vd.checkInputDouble("Please input side B of Triangle: ");
            double c = vd.checkInputDouble("Please input side C of Triangle: ");
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                view.displayMess("Invalid input, please input again!");
            }
        }
    }

    public Rectangle inputRectangle() {
        while (true) {
            double width = vd.checkInputDouble("Please input side width of Rectangle: ");
            double length = vd.checkInputDouble("Please input length of Rectangle: ");
            return new Rectangle(width, length);
        }
    }

    public Circle inputCircle() {
        while (true) {
            double radius = vd.checkInputDouble("Please input radius of Circle: ");
            return new Circle(radius);
        }
    }
    
    public void display(Circle circle, Triangle trigle, Rectangle rectangle) {
        circle.printResult();
        trigle.printResult();
        rectangle.printResult();
    }
}
