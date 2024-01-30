package Model;

public class BMIdata {
    private double weight;
    private double height;
    private double BMI;
    private String status;

    public BMIdata() {}
    public BMIdata(double weight, double height, double BMI, String status) {
        this.weight = weight;
        this.height = height;
        this.BMI = BMI;
        this.status = status;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

