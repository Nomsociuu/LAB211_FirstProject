package Model;

public class Model {
    private double A;
    private double B;
    private double C;

    public Model(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public Model() {

    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public double getC() {
        return C;
    }

    public void setA(double A) {
        this.A = A;
    }

    public void setB(double B) {
        this.B = B;
    }

    public void setC(double C) {
        this.C = C;
    }
}
