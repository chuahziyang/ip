import java.util.Scanner;
public class Ziyang {

    public static void wrapPrint(String msg){
      System.out.println("---------------------------");
      System.out.println(msg);
      System.out.println("---------------------------");
    }
    public static void main(String[] args) {

      wrapPrint("Hello! I'm Zi Yang\nWhat can I do for you?");
      Task[] items = new Task[100];
      Scanner myObj = new Scanner(System.in);  // Create a Scanner object

      String input = myObj.nextLine();
      int i = 0;
      while (true) {
        try{
          if(input.equals("bye") == true){
            break;
          }
          else if (input.equals("list")) {
            String msg = "Here are the tasks in your list:\n";
            for (int j = 0; j < i; j++) {
              if (items[j].isDeleted() == false) {
                msg += j + ". " + items[j].toString() + "\n";
              }
            }
            wrapPrint(msg);
          }
          else if (input.startsWith("mark")) {
            String j = input.split(" ")[1];
            items[Integer.parseInt(j)].mark();
            wrapPrint("Nice! I've marked this task as done:\n " + items[Integer.parseInt(j)].toString());
          }
          else if (input.startsWith("delete")) {
            String j = input.split(" ")[1];
            items[Integer.parseInt(j)].delete();
            wrapPrint("Nice! I've marked this task as deleted:\n " + items[Integer.parseInt(j)].toString());
          }
          else if (input.startsWith("todo")) {
            String j = input.split(" ")[1];
            items[i] = new Task(j, Task.Type.T, "", "");
            i++;
            wrapPrint("added: " + j);
          }
          else if (input.startsWith("deadline")) {
            String j = input.split(" ")[1];
            String deadline = input.split(" ")[3];;
            items[i] = new Task(j, Task.Type.D, "", deadline);
            i++;
            wrapPrint("added: " + j);
          }
          else if (input.startsWith("event")) {
            String j = input.split(" ")[1];
            String start = input.split(" ")[3];
            String end = input.split(" ")[5];
            items[i] = new Task(j, Task.Type.E, start, end);
            i++;
            wrapPrint("added: " + j);
          }
          else{
            wrapPrint("I don't understand what you want to do. Please try again.");
          }
          input = myObj.nextLine();
        }
        catch (Exception e){
          wrapPrint("Incorrect input, please try again.");
          input = myObj.nextLine();
        }
      }

      System.out.println("---------------------------");
      System.out.println("Bye. Hope to see you again soon!");
      System.out.println("---------------------------");
    }
}

