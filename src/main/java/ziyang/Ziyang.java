package ziyang;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Ziyang {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        UI ui = new UI();
        Storage storage = new Storage("database.data");

        LinkedList<Task> items = storage.read();
        Parser parser = new Parser(items);

        ui.welcome();


        parser.getInput();

        while (true) {
            if (parser.isEnd()) {
                break;
            }
            String msg = parser.evaluate();
            ui.answer(msg);
            parser.getInput();
        }

        storage.write(items);

        ui.answer("Bye. Hope to see you again soon!");
    }

    public String getResponse(String input) {
        return "Duke heard: " + input;
    }
}

