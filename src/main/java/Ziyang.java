
public class Ziyang {
    public static void main(String[] args) {
      System.out.println("Hello! I'm Zi Yang");
      System.out.println("What can I do for you?");
      System.out.println("---------------------------");

      String[] items = new String[100];

      String input = System.console().readLine();
      int i = 0;
      while (input.equals("bye") == false) {
        if (input.equals("list")) {
          System.out.println("---------------------------");
          for (int j = 0; j < i; j++) {
            System.out.println(j + ". " + items[j]);
          }
          System.out.println("---------------------------");
        }
        else{
          System.out.println("---------------------------");
          items[i] = input;
          i++;
          System.out.println("added: " + input);
          System.out.println("---------------------------");
        }
        input = System.console().readLine();
      }

      System.out.println("---------------------------");
      System.out.println("Bye. Hope to see you again soon!");
      System.out.println("---------------------------");
    }
}

