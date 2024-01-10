package LAB211.CharacterCount.Model;

import java.util.*;

public class Model {

    public String str;
    public Map<Character, Integer> charCount = new HashMap<Character, Integer>();

    public Map<String, Integer> wordCount = new HashMap<String, Integer>();

    public Model (String str) {
        this.str = str;
    }

    public Model() {
        super();
    }
    
    public void setString(String str){
        this.str = str;
    }

    public String getString() {
        return str;
    }

    public Map<Character, Integer> getCharCount() {
        return charCount;
    }

    public void setCharCount(Map<Character, Integer> charCount) {
        this.charCount = charCount;
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }

    public void setWordCount(Map<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }
}
