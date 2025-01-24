
public class Ziyang {

    public static void wrapPrint(String msg){
      System.out.println("---------------------------");
      System.out.println(msg);
      System.out.println("---------------------------");
    }
    public static void main(String[] args) {

      wrapPrint("Hello! I'm Zi Yang\nWhat can I do for you?");
      Task[] items = new Task[100];

      String input = System.console().readLine();
      int i = 0;
      while (true) {
        if(input.equals("bye") == true){
          break;
        }
        else if (input.equals("list")) {
          String msg = "Here are the tasks in your list:\n";
          for (int j = 0; j < i; j++) {
            msg += j + ". " + items[j].toString() + "\n";
          }
          wrapPrint(msg);
        }
        else if (input.startsWith("mark")) {
          String j = input.split(" ")[1];
          items[Integer.parseInt(j)].mark();
          wrapPrint("Nice! I've marked this task as done:\n " + items[Integer.parseInt(j)].toString());
        }
        else{
          items[i] = new Task(input);
          i++;
          wrapPrint("added: " + input);
        }
        input = System.console().readLine();
      }

      System.out.println("---------------------------");
      System.out.println("Bye. Hope to see you again soon!");
      System.out.println("---------------------------");
    }
}

