package Common;

import Model.Task;
import View.Display;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
            int taskTypeId = Integer.parseInt(taskType);
            Date taskDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            double from = Double.parseDouble(planFrom);
            double to = Double.parseDouble(planTo);

            vali.taskInput(taskTypeId, from, to);

            lastTaskId++;

            Task task = new Task(lastTaskId, taskTypeId, requirementName, assignee, reviewer, taskDate, from, to);
            tasks.add(task);

            return lastTaskId;
        } catch (NumberFormatException | NullPointerException e) {
            throw new Exception("Error adding task: " + e.getMessage());
        }
    }

    public void deleteTask(String taskId) throws Exception {
        try {
            dis.showDetailMenu("Del Task");
            int id = Integer.parseInt(taskId);

            tasks.removeIf(task -> task.getId() == id);

            System.out.println("Task deleted successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error deleting task: Invalid task ID format.");
        }
    }

    public List<Task> getDataTasks() {
        dis.showDetailMenu("Task");

        List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparingInt(Task::getId))
                .collect(Collectors.toList());

        for (Task task : sortedTasks) {
            System.out.println(task);
        }

        return sortedTasks;
    }
}
