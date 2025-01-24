
public class Ziyang {
    public static void main(String[] args) {
      System.out.println("Hello! I'm Zi Yang");
      System.out.println("What can I do for you?");
      System.out.println("---------------------------");

      String input = System.console().readLine();
      while (input.equals("bye") == false) {
        System.out.println("---------------------------");
        System.out.println(input);
        System.out.println("---------------------------");
        input = System.console().readLine();
      }

      System.out.println("---------------------------");
      System.out.println("Bye. Hope to see you again soon!");
      System.out.println("---------------------------");
    }
}

