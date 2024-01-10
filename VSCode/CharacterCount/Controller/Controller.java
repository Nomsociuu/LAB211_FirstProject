package LAB211.CharacterCount.Controller;

import java.util.*;

import LAB211.CharacterCount.Model.*;
//import LAB211.CharacterCount.View.*;

public class Controller {

    private Model models = new Model();
    //private static final Scanner scanner = new Scanner(System.in);
    
    private Map<Character, Integer> charCount = 
            new HashMap<Character, Integer>();

    
    
    private Map<String, Integer> wordCount =
            new HashMap<String, Integer>();

    // public Controller() {
    //     super("Character Count", new String[]{"Add String", "Count Character", "Word Count"});
    // }

    // @Override
    // public void execute(int choice) {
    //     switch (choice) {
    //         case 1:
    //             Input();
    //             break;
    //         case 2:
    //             String Charc = models.getString();
    //             CharacterCount(Charc);
    //             break;
    //         case 3:
    //             String Wordc = models.getString();
    //             WordCount(Wordc);
    //     }
    // }
    
    // public void display() {
    //     System.out.println(models.getWordCount());
    //     System.out.println(models.getCharCount());
    // }
    
    public void CharacterCount(String str) {
        //String charC = models.getString();
        models.setCharCount(charCount);
        for (char ch : str.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!models.charCount.containsKey(ch)) {
                charCount.put(ch, 1);
            } 
            else {
                charCount.put(ch, ((int) charCount.get(ch)) + 1);
            }
        }
        System.out.println(models.getCharCount());
    }
    public void WordCount(String str) {
        models.setWordCount(wordCount);
        StringTokenizer tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCount.containsKey(token)) {
                wordCount.put(token, 1);
            } else {
                wordCount.put(token, ((int) wordCount.get(token)) + 1);
            }
        }
        System.out.println(models.getWordCount());
    }

    // public static void main(String args[]) {
    //     Controller controller = new Controller();
    //     controller.run();
    // }
}

