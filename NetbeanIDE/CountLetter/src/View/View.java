package View;

import java.util.Map;

public class View {

    public void displayWordCounts(Map<String, Integer> wordCountMap) {
        System.out.println("Word Counts: " + wordCountMap);
    }

    public void displayCharCounts(Map<Character, Integer> charCountMap) {
        System.out.println("Character Counts: " + charCountMap);
    }
    public static void Menu(){
        System.out.println("____Counting Word And Character____");
        System.out.println("1.Input String");
        System.out.println("2.Count Word");
        System.out.println("3.Count Character");
        System.out.println("4.Exit");
    }
}
