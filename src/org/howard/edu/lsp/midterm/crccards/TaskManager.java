package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of Task objects.
 * Supports adding tasks, finding tasks by ID, and retrieving tasks by status.
 *
 * @author Nicholas Abram
 */
public class TaskManager {
    private Map<String, Task> tasks;

    /**
     * Constructs an empty TaskManager.
     */
    public TaskManager() {
        tasks = new LinkedHashMap<>();
    }

    /**
     * Adds a task to the manager.
     * Duplicate task IDs are not allowed.
     *
     * @param task the task to add
     * @throws IllegalArgumentException if a task with the same task ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds and returns a task by its task ID.
     *
     * @param taskId the task ID to search for
     * @return the matching task if found; null otherwise
     */
    public Task findTask(String taskId) {
        return tasks.get(taskId);
    }

    /**
     * Returns a list of tasks whose status matches the given status.
     *
     * @param status the status to match
     * @return a list of tasks with the specified status
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> matchingTasks = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                matchingTasks.add(task);
            }
        }

        return matchingTasks;
    }
}