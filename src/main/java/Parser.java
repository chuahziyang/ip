import java.util.Scanner;
import java.util.LinkedList;
public class Parser {

  public String nextinput;
  public Scanner sc = new Scanner(System.in);
  public LinkedList<Task> items;

  public Parser(LinkedList<Task> items){
    this.items = items;
  }

  public void getInput(){
    this.nextinput = this.sc.nextLine();
  }

  public boolean isEnd(){
    return this.nextinput.equals("bye");
  }

  public String evaluate(){
    if(this.nextinput.equals("list")){
      String msg = "Here are the tasks in your list:\n";
      int i = 0;
      for (Task item : items) {
        msg += i + "." + item.toString() + "\n";
        i++;
      }
      return msg;
    }
    else if (this.nextinput.startsWith("mark")) {
      String j = this.nextinput.split(" ")[1];
      items.get(Integer.parseInt(j)).mark();
      return "Nice! I've marked this task as done:\n " + items.get(Integer.parseInt(j)).toString();
    }
    else if (this.nextinput.startsWith("delete")) {
      String j = this.nextinput.split(" ")[1];
      items.remove(Integer.parseInt(j));
      return "Nice! I've marked this task as deleted";
    }
    else if (this.nextinput.startsWith("todo")) {
      String j = this.nextinput.split(" " ,2)[1];
      items.add(new todoTask(j));
      return "added: " + j;
    }
    else if (this.nextinput.startsWith("deadline")) {
      String j = this.nextinput.split("/")[0].split(" ", 2)[1];
      String deadline = this.nextinput.split("/")[1].split(" ", 2)[1];
      items.add(new deadlineTask(j, deadline));
      return "added: " + j;
    }
    else if (this.nextinput.startsWith("event")) {
      String j = this.nextinput.split("/")[0].split(" ", 2)[1];
      String start = this.nextinput.split("/")[1].split(" ", 2)[1];
      String end = this.nextinput.split("/")[2].split(" ", 2)[1];
      items.add(new eventTask(j, start, end));
      return "added: " + j;
    }
    else{
      return "I don't understand what you want to do. Please try again.";
    }
  }


}
