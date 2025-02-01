package ziyang;

import java.time.LocalDate;

public class eventTask extends Task {
    public LocalDate start;
    public LocalDate end;

    public eventTask(String description, String start, String end) {
        super(description);
        LocalDate startdate = LocalDate.parse(start);
        LocalDate enddate = LocalDate.parse(end);
        this.start = startdate;
        this.end = enddate;
    }

    public String toString() {
        return "[E]" + this.getStatusIcon() + this.description + "(time: " + this.start + " ~ " + this.end + ")";
    }
}
