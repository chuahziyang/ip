import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class Ziyang {
    public static void main(String[] args) throws FileNotFoundException , IOException {
      UI ui = new UI();
      Storage storage = new Storage("database.data");
      
      LinkedList<Task> items = storage.read();
      Parser parser = new Parser(items);

      ui.welcome();


      parser.getInput();

      while (true) {
        if(parser.isEnd()){
          break;
        }
        String msg = parser.evaluate();
        ui.answer(msg);
        parser.getInput();
      }

      storage.write(items);

      ui.answer("Bye. Hope to see you again soon!");
    }
}

