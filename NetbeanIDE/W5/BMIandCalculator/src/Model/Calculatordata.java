package Model;

public class Calculatordata {
    private char op;
    private double memory;
    private double num1;
    private double num2;
    private double result;

    public Calculatordata() {}
    public Calculatordata(char op, double memory, double num1, double num2, double result) {
        this.op = op;
        this.memory = memory;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


}
