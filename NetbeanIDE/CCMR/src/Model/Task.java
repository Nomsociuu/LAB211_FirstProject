package Model;

import java.util.Date;

public class Task {

    //Attributes
    private int TaskTypeID, id;
    private double PlanTo, PlanFrom;
    private String RequirementName, Assignee, Reviewer;
    private Date Date;

    public Task() {
    }

    public Task(int id, String RequirementName, String Assignee, String Reviewer, int TaskTypeID, Date Date, double PlanTo, double PlanFrom) {
        this.TaskTypeID = TaskTypeID;
        this.id = id;
        this.PlanTo = PlanTo;
        this.PlanFrom = PlanFrom;
        this.RequirementName = RequirementName;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
        this.Date = Date;
    }

    public int getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPlanTo() {
        return PlanTo;
    }

    public void setPlanTo(double PlanTo) {
        this.PlanTo = PlanTo;
    }

    public double getPlanFrom() {
        return PlanFrom;
    }

    public void setPlanFrom(double PlanFrom) {
        this.PlanFrom = PlanFrom;
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Task{" + "TaskTypeID=" + TaskTypeID + ", id=" + id + ", PlanTo=" + PlanTo + ", PlanFrom=" + PlanFrom + ", RequirementName=" + RequirementName + ", Assignee=" + Assignee + ", Reviewer=" + Reviewer + ", Date=" + Date + '}';
    }
    
    

    

}
