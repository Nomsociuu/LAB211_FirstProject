package Model;

import java.util.HashMap;
import java.util.List;

public class Analysis {

    public Analysis() {
    }

    public HashMap<String, List<Integer>> getNumber(String input) {

        AnalysisNumber num = new AnalysisNumber(input);

        HashMap<String, List<Integer>> result = new HashMap<>();

        result.put("Perfect Square Numbers", num.getperSquareNum());
        result.put("Odd Numbers", num.getoddNum());
        result.put("Even Numbers", num.getevenNum());
        result.put("All Numbers", num.getallNum());

        return result;
    }

    public HashMap<String, StringBuilder> getCharacter(String input) {

        AnalysisChar ch = new AnalysisChar(input);

        HashMap<String, StringBuilder> result = new HashMap<>();

        result.put("Uppercase Characters", ch.getupperChar());
        result.put("Lowercase Characters", ch.getlowerChar());
        result.put("Special Characters", ch.getspeChar());
        result.put("All Characters", ch.getallChar());

        return result;
    }
}
