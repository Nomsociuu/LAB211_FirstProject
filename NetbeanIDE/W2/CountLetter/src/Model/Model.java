package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Model {

    private String string;
    private String[] letter;
    private String[] charac;

    public Model(String[] letter, String[] charac) {
        this.letter = letter;
        this.charac = charac;
    }

    public Model() {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String[] getLetter() {
        return letter;
    }

    public void setLetter(String[] letter) {
        this.letter = letter;
    }

    public String[] getCharac() {
        return charac;
    }

    public void setCharac(String[] charac) {
        this.charac = charac;
    }
    
    public Map<String, Integer> countWords(String inputString) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(inputString);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public Map<Character, Integer> countCharacters(String inputString) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }

        return charCountMap;
    }
}
