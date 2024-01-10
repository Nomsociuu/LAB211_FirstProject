package Controller;

import Model.Model;
import View.View;
import java.util.Map;
import java.util.Scanner;

public class Controller {

    private Scanner sc = new Scanner(System.in);

    private final Model model = new Model();

    private final View view = new View();

    public void processInput() {

        System.out.println("Enter a string:");
        sc.nextLine();
        String inputString = sc.nextLine();
        model.setString(inputString);
        System.out.println("Typed success!");
        System.out.println("The string is: " + inputString);
    }

    public void countWord() {
        Map<String, Integer> wordCountMap = model.countWords(model.getString());
        view.displayWordCounts(wordCountMap);
    }

    public void countChar() {
        Map<Character, Integer> charCountMap = model.countCharacters(model.getString());
        view.displayCharCounts(charCountMap);
    }

    public void run() {
        int choice;
        View.Menu();

        do {
            System.out.print("Enter selection: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    processInput();
                    break;
                case 2:
                    countWord();
                    break;
                case 3:
                    countChar();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (choice > 0 && choice < 4);

        sc.close();
    }

}
