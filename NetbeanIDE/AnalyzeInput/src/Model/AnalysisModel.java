
package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisModel {
    public Map<String, List<Integer>> analyzeNumbers(String input) {
        Map<String, List<Integer>> result = new HashMap<>();

        List<Integer> perfectSquareNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> allNumbers = new ArrayList<>();

        // Implement logic for analyzing numbers
        String[] numberStrings = input.replaceAll("[^0-9]+", " ").trim().split("\\s+");

        for (String numStr : numberStrings) {
            int number = Integer.parseInt(numStr);

            // Check for perfect square
            double sqrt = Math.sqrt(number);
            if (Math.abs(sqrt - Math.floor(sqrt)) < 1e-10) {
                perfectSquareNumbers.add(number);
            }

            // Check for odd and even numbers
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }

            allNumbers.add(number);
        }

        result.put("Perfect Square Numbers", perfectSquareNumbers);
        result.put("Odd Numbers", oddNumbers);
        result.put("Even Numbers", evenNumbers);
        result.put("All Numbers", allNumbers);

        return result;
    }

    public Map<String, StringBuilder> analyzeCharacters(String input) {
        Map<String, StringBuilder> result = new HashMap<>();

        StringBuilder uppercaseChars = new StringBuilder();
        StringBuilder lowercaseChars = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();
        StringBuilder allChars = new StringBuilder();

        // Implement logic for analyzing characters
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseChars.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lowercaseChars.append(ch);
            } else if (Character.isDigit(ch)) {
                // Skip digits for character analysis
                continue;
            } else {
                specialChars.append(ch);
            }

            allChars.append(ch);
        }

        result.put("Uppercase Characters", uppercaseChars);
        result.put("Lowercase Characters", lowercaseChars);
        result.put("Special Characters", specialChars);
        result.put("All Characters", allChars);

        return result;
    }
}
