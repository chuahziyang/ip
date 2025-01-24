
public class Task {
    protected String description;
    protected boolean isDone;
    protected enum Type {T, D, E};
    protected Type type = Type.T;
    protected String by;
    protected String from;

    public Task(String description, Type type, String from, String by) {
        this.description = description;
        this.isDone = false;
        this.type = type;
        this.by = by;
        this.from = from;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void mark(){
      this.isDone = true;
    }

    public String extras(){
      switch(this.type){
        case T:
          return "";
        case D:
          return " (by: " + this.by + ")";
        case E:
          return " (from: " + this.from + " to: " + this.by + ")";
      }
      return "";
    }

    public String toString() {
        return "[" + this.type +  "]" + "[" + this.getStatusIcon() + "]" + description + this.extras();
    }

}
