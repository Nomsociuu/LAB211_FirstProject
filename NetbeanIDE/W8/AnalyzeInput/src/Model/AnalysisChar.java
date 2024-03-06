package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysisChar {

    private StringBuilder upperChar = new StringBuilder();
    private StringBuilder lowerChar = new StringBuilder();
    private StringBuilder speChar = new StringBuilder();
    private StringBuilder allChar = new StringBuilder();
    private String input;

    public AnalysisChar(String input) {
        this.input = input;
    }

    public StringBuilder getupperChar() {
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperChar.append(ch);
            }
        }
        return upperChar;
    }

    public StringBuilder getlowerChar() {
        for (char ch : input.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lowerChar.append(ch);
            }
        }
        return lowerChar;
    }

    public StringBuilder getspeChar() {
        Matcher matcher = Pattern.compile("[^a-zA-Z0-9]").matcher(input);

        while (matcher.find()) {
            speChar.append(matcher.group());
        }

        return speChar;
    }

    public StringBuilder getallChar() {
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                continue;
            }
            allChar.append(ch);
        }
        return allChar;
    }
}
