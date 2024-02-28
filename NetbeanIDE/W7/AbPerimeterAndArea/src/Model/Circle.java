
package Model;

public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public void printResult() {
        System.out.println("-----Circle-----" 
                + "\nRadius: " + this.radius 
                + "\nArea: " + getArea() 
                + "\nPerimeter: " + getPerimeter());
    }    
}