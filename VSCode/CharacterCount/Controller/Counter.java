package LAB211.CharacterCount.Controller;

import java.util.*;

import LAB211.CharacterCount.Model.*;
import LAB211.CharacterCount.View.*;

public class Counter extends Menu{
    private static final Scanner scanner = new Scanner(System.in);
    public Counter (){
        super("\n>Character Count<", new String[]{"Add String", "Count Character", "Word Count", "Exit"});

    }
    Controller control = new Controller();
    Model models = new Model();

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter a string: ");
                String str = scanner.nextLine();
                models.setString(str);
                break;
            case 2:
                System.out.println();
                String Charc = models.getString();
                if (Charc == null) {
                    System.out.println("Empty string, moving to option: \"Enter a string\"...");
                    System.out.print("Enter a string: ");
                    String stringCc = scanner.nextLine();
                    models.setString(stringCc);
                    String temp1 = models.getString();
                    control.CharacterCount(temp1);
                }
                else {
                    control.CharacterCount(Charc);
                }
                //System.out.println(models.getCharCount());
                break;
            case 3:
                System.out.println();
                String Wordc = models.getString();
                if (Wordc == null) {
                    System.out.println("Empty string, moving to option: \"Enter a string\"...");
                    System.out.print("Enter a string: ");
                    String stringCc = scanner.nextLine();
                    models.setString(stringCc);
                    String temp1 = models.getString();
                    control.CharacterCount(temp1);
                }
                else{
                    control.WordCount(Wordc);
                }
                //System.out.println(models.getWordCount());
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public void runner() {
        Counter count = new Counter();
        count.run();
    }
}