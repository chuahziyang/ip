import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class Ziyang {
    public static void wrapPrint(String msg){
      System.out.println("---------------------------");
      System.out.println(msg);
      System.out.println("---------------------------");
    }
    public static void main(String[] args) throws FileNotFoundException , IOException {

      wrapPrint("Hello! I'm Zi Yang\nWhat can I do for you?");

      LinkedList<Task> items = null;


      try{
        FileInputStream fileIn = new FileInputStream("database.data");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        items = (LinkedList<Task>) in.readObject();
        in.close();
        fileIn.close();
      }catch (Exception e){
        System.out.println("No database found.");
        items = new LinkedList<Task>();
      }

      FileOutputStream fileOut = new FileOutputStream("database.data");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);

      Scanner myObj = new Scanner(System.in);  // Create a Scanner object
      String input = myObj.nextLine();

      while (true) {
        try{
          if(input.equals("bye") == true){
            break;
          }
          else if (input.equals("list")) {
            String msg = "Here are the tasks in your list:\n";
            int i = 0;
            for (Task item : items) {
              msg += i + "." + item.toString() + "\n";
              i++;
            }
            wrapPrint(msg);
          }
          else if (input.startsWith("mark")) {
            String j = input.split(" ")[1];
            items.get(Integer.parseInt(j)).mark();
            wrapPrint("Nice! I've marked this task as done:\n " + items.get(Integer.parseInt(j)).toString());
          }
          else if (input.startsWith("delete")) {
            String j = input.split(" ")[1];
            items.remove(Integer.parseInt(j));
            wrapPrint("Nice! I've marked this task as deleted");
          }
          else if (input.startsWith("todo")) {
            String j = input.split(" " ,2)[1];
            items.add(new todoTask(j));
            wrapPrint("added: " + j);
          }
          else if (input.startsWith("deadline")) {
            String j = input.split("/")[0].split(" ", 2)[1];
            String deadline = input.split("/")[1].split(" ", 2)[1];
            items.add(new deadlineTask(j, deadline));
            wrapPrint("added: " + j);
          }
          else if (input.startsWith("event")) {
            String j = input.split("/")[0].split(" ", 2)[1];
            String start = input.split("/")[1].split(" ", 2)[1];
            String end = input.split("/")[2].split(" ", 2)[1];
            items.add(new eventTask(j, start, end));
            wrapPrint("added: " + j);
          }
          else{
            wrapPrint("I don't understand what you want to do. Please try again.");
          }
          input = myObj.nextLine();
        }
        catch (Exception e){
          System.out.println(e);
          wrapPrint("Incorrect input, please try again.");
          input = myObj.nextLine();
        }
      }

      out.writeObject(items);
      out.close();
      fileOut.close();
      System.out.println("---------------------------");
      System.out.println("Bye. Hope to see you again soon!");
      System.out.println("---------------------------");
    }
}

