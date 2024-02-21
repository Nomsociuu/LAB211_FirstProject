package Model;

import java.util.*;

public class History {
    private String id;
    private double oldSalary;
    private double newSalary;
    private String Status;
    private Date date;

    public History(String id, double oldSalary, double newSalary,String Status, Date date) {
        this.id = id;
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        this.Status = Status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public double getOldSalary() {
        return oldSalary;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
