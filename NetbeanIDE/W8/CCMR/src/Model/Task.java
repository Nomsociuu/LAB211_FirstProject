package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    //Attributes
    private int TaskTypeID,id;
    private double PlanTo, PlanFrom;
    private String RequirementName, Assignee, Reviewer;
    private Date Date;

    public Task() {
    }

    public Task(int id, int TaskTypeID, String RequirementName, String Assignee, String Reviewer, Date Date, double PlanTo, double PlanFrom) {
        this.id = id;
        this.TaskTypeID = TaskTypeID;
        this.PlanTo = PlanTo;
        this.PlanFrom = PlanFrom;
        this.RequirementName = RequirementName;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
        this.Date = Date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
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

    private String getTaskType() {
        switch (TaskTypeID) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
            default:
                return "Unknown";
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("ID Name		    Task Type	 Date	   Time    Assignee	   Reviewer");
        return String.format("%-4s %-20s %-12s %-10s %-9.1f %-15s %-10s",
                id, RequirementName, getTaskType(), dateFormat.format(Date),
                (PlanFrom - PlanTo), Assignee, Reviewer);
    }
}
