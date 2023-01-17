package P_P_3;

class Task {
    private String task;
    private boolean completed;

    public Task(String task) {
        this(task, false);
    }

    public Task(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String toString() {
        return task + (completed ? " (Completed)" : "");
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task t = (Task) o;
        return t.getTask().equals(this.getTask());
    }
}
