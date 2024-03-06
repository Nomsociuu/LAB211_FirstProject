package Model;

import java.util.ArrayList;
import java.util.List;

public class AnalysisNumber {

    private List<Integer> perSquareNum = new ArrayList<>();
    private List<Integer> oddNum = new ArrayList<>();
    private List<Integer> evenNum = new ArrayList<>();

    private List<Integer> input = new ArrayList<>();

    public AnalysisNumber(String input) {
        this.input = parseNumbers(input);
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> parsedNumbers = new ArrayList<>();
        String[] numberStrings = input.replaceAll("[^0-9]+", " ").trim().split("\\s+");
        for (String numStr : numberStrings) {
            int number = Integer.parseInt(numStr);
            parsedNumbers.add(number);
        }
        return parsedNumbers;
    }

    public List<Integer> getperSquareNum() {
        for (int number : input) {
            double sqrt = Math.sqrt(number);
            if (Math.abs(sqrt - Math.floor(sqrt)) < 1e-10) {
                perSquareNum.add(number);
            }
        }
        return perSquareNum;
    }

    public List<Integer> getoddNum() {
        for (int number : input) {
            if (number % 2 != 0) {
                oddNum.add(number);
            }
        }
        return oddNum;
    }

    public List<Integer> getevenNum() {
        for (int number : input) {
            if (number % 2 == 0) {
                evenNum.add(number);
            }
        }
        return evenNum;
    }

    public List<Integer> getallNum() {
        return input;
    }
}
