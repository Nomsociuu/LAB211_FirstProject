package Controller;

import Utilities.Manage;
import View.Menu;

public class Control extends Menu {

    final Manage mng = new Manage();
    private String filename=  "data.txt";

    public Control() {
        super("\nDictionary", new String[] {
            "Add word", "Delete word", "Translate word", "Exit"
        });
    }

    public void reader() {
        mng.readFile(filename);
    }
    
    public void execute(int choice) {
        reader();
        switch (choice) {
            case 1:
                mng.addWord();
                mng.writeFile(filename);
                break;
            case 2: 
                mng.deleteWord();
                mng.writeFile(filename);
                break;
            case 3:
                mng.translateWord();
                break;
            case 4:
                System.exit(0);
        }
    }
}
