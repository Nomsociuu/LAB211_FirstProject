package model;

public class Truck {
    private int total;
    private int time;
    private int cost;
    private int number;

    public Truck() {
    }

    public Truck(int total, int time, int cost, int number) {
        this.total = total;
        this.time = time;
        this.cost = cost;
        this.number = number;
    } 

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
}