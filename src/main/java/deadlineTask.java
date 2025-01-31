
public class deadlineTask extends Task {
    public String deadline;
    public deadlineTask(String description, String deadline) {
      super(description);
      this.deadline = deadline;
    }

    public String toString() {
        return "[D]" + this.getStatusIcon() + this.description + "(by: " + this.deadline + ")";
    }
}
