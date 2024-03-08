package Common;

import Model.Task;
import View.Display;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Algo {

    Display dis = new Display();
    Validate vali;
    private List<Task> tasks;
    private int lastTaskId;

    public Algo(Validate vali) {
        this.vali = vali;
        tasks = new ArrayList<>();
        lastTaskId = 0;
    }

    public int addTask(String requirementName, String taskType, String date, String planFrom,
            String planTo, String assignee, String reviewer) throws Exception {

        try {
            dis.showDetailMenu("Add Task");

            int taskTypeId = Integer.parseInt(taskType);
            Date taskDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            double from = Double.parseDouble(planFrom);
            double to = Double.parseDouble(planTo);

            validateTaskInput(taskTypeId, from, to);

            lastTaskId++;

            Task task = new Task(lastTaskId, requirementName, assignee, reviewer, taskTypeId, taskDate, from, to);
            tasks.add(task);

            return lastTaskId;
        } catch (NumberFormatException | NullPointerException e) {
            throw new Exception("Error adding task: " + e.getMessage());
        }
    }

    private void validateTaskInput(int taskTypeId, double planFrom, double planTo) throws Exception {
        if (taskTypeId < 1 || taskTypeId > 4) {
            throw new Exception("Invalid Task Type. Task Type must be between 1 and 4.");
        }

        if (planFrom < 8.0 || planTo > 17.5 || planFrom >= planTo) {
            throw new Exception("Invalid time range. Plan From must be before Plan To and between 8.0 and 17.5.");
        }
    }

    public void deleteTask(String taskId) {

        try {
            dis.showDetailMenu("Del Task");
            int id = Integer.parseInt(taskId);

            tasks.removeIf(task -> task.getId() == id);

            System.out.println("Task deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }

    public List<Task> getDataTasks() {
        dis.showDetailMenu("Task");
        return tasks.stream()
                .sorted(Comparator.comparingInt(Task::getId))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
