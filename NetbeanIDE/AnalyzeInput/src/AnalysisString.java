
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;

public class AnalysisString {

    public static void main(String[] args) {
        // Function 1: Display Gui And Input Data
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Analysis String program =====");
        System.out.print("Input String: ");
        String input = sc.nextLine();

        // Function 2: Perform Analysis
        HashMap<String, List<Integer>> numberResult = getNumber(input);
        HashMap<String, StringBuilder> characterResult = getCharacter(input);

        // Display Analysis Results
        System.out.println("\n-----Result Analysis------");
        System.out.println("Perfect Square Numbers: " + numberResult.get("perfectSquare"));
        System.out.println("Odd Numbers: " + numberResult.get("odd"));
        System.out.println("Even Numbers: " + numberResult.get("even"));
        System.out.println("All Numbers: " + numberResult.get("all"));
        System.out.println("Uppercase Characters: " + characterResult.get("uppercase"));
        System.out.println("Lowercase Characters: " + characterResult.get("lowercase"));
        System.out.println("Special Characters: " + characterResult.get("special"));
        System.out.println("All Characters: " + characterResult.get("all"));
    }

    // Function 2: Analyze the number types
    public static HashMap<String, List<Integer>> getNumber(String input) {
        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> perfectSquareNumbers = new ArrayList<>();

        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher matcher = numberPattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            allNumbers.add(number);
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
            double sqrt = Math.sqrt(number); //5.00
            if (sqrt == Math.floor(sqrt) && sqrt > 0) {
                perfectSquareNumbers.add(number);
            }
        }

        result.put("all", allNumbers);
        result.put("even", evenNumbers);
        result.put("odd", oddNumbers);
        result.put("perfectSquare", perfectSquareNumbers);

        return result;
    }

    // Function 2: Analyze the character types and special characters
    public static HashMap<String, StringBuilder> getCharacter(String input) {
        HashMap<String, StringBuilder> result = new HashMap<>();
        StringBuilder allCharacters = new StringBuilder();
        StringBuilder uppercaseCharacters = new StringBuilder();
        StringBuilder lowercaseCharacters = new StringBuilder();
        StringBuilder specialCharacters = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                allCharacters.append(c);
            }
        }

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCharacters.append(c);
            } else if (Character.isLowerCase(c)) {
                lowercaseCharacters.append(c);
            } else if (!Character.isLetterOrDigit(c)) {
                specialCharacters.append(c);
            }
        }

        result.put("all", allCharacters);
        result.put("uppercase", uppercaseCharacters);
        result.put("lowercase", lowercaseCharacters);
        result.put("special", specialCharacters);

        return result;
    }
}
