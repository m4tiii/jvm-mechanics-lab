package pl.rokitowski.core.language.lambdas.model;

import java.time.LocalDate;

public class Task {
    private String title;
    private int priority;
    private boolean completed;
    private LocalDate dueDate;

    public Task(String title, int priority, boolean completed, LocalDate dueDate) {
        this.title = title;
        this.priority = priority;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public LocalDate getDueDate() { return dueDate; }

    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setTitle(String title) { this.title = title; }

}
