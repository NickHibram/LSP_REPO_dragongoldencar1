package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task in the task management system.
 * A task stores its ID, description, and status.
 *
 * @author Nicholas Abram
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a task with the given task ID and description.
     * The default status is OPEN.
     *
     * @param taskId the unique ID of the task
     * @param description the description of the task
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the current task status.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * Valid status values are OPEN, IN_PROGRESS, and COMPLETE.
     * If the given status is invalid, the status is set to UNKNOWN.
     *
     * @param status the new status for the task
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns the task details in the format:
     * taskId description [status]
     *
     * @return the formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}