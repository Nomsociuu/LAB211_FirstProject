package Common;

import Model.AnalysisModel;
import View.Display;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Algo {

    private AnalysisModel model;

    Scanner sc = new Scanner(System.in);
    Display dis;

    public Algo() {

        this.model = new AnalysisModel();
    }

    public void Analize() {
        String input = "321sdhkjDFGH!@#$%^22fdsf3";
        System.out.println("-----Result Analysis------");
        // Analyze numbers
        Map<String, List<Integer>> numbersAnalysis = model.analyzeNumbers(input);

        // Analyze characters
        Map<String, StringBuilder> charactersAnalysis = model.analyzeCharacters(input);

        // Display the results (you can modify this based on your UI requirements)
        System.out.println("Perfect Square Numbers: " + numbersAnalysis.get("Perfect Square Numbers"));
        System.out.println("Odd Numbers: " + numbersAnalysis.get("Odd Numbers"));
        System.out.println("Even Numbers: " + numbersAnalysis.get("Even Numbers"));
        System.out.println("All Numbers: " + numbersAnalysis.get("All Numbers"));
        System.out.println("Uppercase Characters: " + charactersAnalysis.get("Uppercase Characters"));
        System.out.println("Lowercase Characters: " + charactersAnalysis.get("Lowercase Characters"));
        System.out.println("Special Characters: " + charactersAnalysis.get("Special Characters"));
        System.out.println("All Characters: " + charactersAnalysis.get("All Characters"));
    }

}
