
public class todoTask extends Task {
    public todoTask(String description) {
        super(description);
    }

    public String toString() {
        return "[T]" + this.getStatusIcon() + this.description;
    }
}
