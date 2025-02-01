package ziyang;

import java.time.LocalDate;

public class deadlineTask extends Task {
    public LocalDate deadline;

    public deadlineTask(String description, String deadline) {
        super(description);
        LocalDate date = LocalDate.parse(deadline);
        this.deadline = date;
    }

    public String toString() {
        return "[D]" + this.getStatusIcon() + this.description + "(by: " + this.deadline + ")";
    }
}
