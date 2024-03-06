package Common;

import Model.Analysis;
import View.Display;
import java.util.HashMap;
import java.util.List;

public class Algo {

    Validate vali = new Validate();
    private Analysis model;
    private Display dis = new Display();

    public Algo() {
        this.model = new Analysis();
    }

    public void Analize() {
        String input = vali.getStringFromInput("Input String: ");
        dis.showDetailMenu("Result Analysis");

        HashMap<String, List<Integer>> numbersAnalysis = model.getNumber(input);
        HashMap<String, StringBuilder> charactersAnalysis = model.getCharacter(input);

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
