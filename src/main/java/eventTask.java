
public class eventTask extends Task {
    public String start;
    public String end;
    public eventTask(String description, String start, String end) {
      super(description);
      this.start = start;
      this.end = end;
    }

    public String toString() {
        return "[E]" + this.getStatusIcon() + this.description + "(time: " + this.start + " ~ " + this.end + ")";
    }
}
