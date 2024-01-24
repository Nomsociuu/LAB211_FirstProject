package Controller;

import java.util.*;

public class newControl {
    public String oneSpaceNormal(String str){
        str=str.trim().replaceAll(" +", " ");
        return str;
    }

    public String signNormal(String str) {
        char ch[] = {',', '.', ':'};
        for (char c : ch) {
            str = str.replace(" " + c, c + "");
            str = str.replace(c+" ", c+"");
            str = str.replace(c+"", c+" ");
        }
        return str;
    }

    public String UpperCase(String str) {
        // str = str.toUpperCase();
        // String upperCase = str.substring(0, 1);
        // String lowerCase = str.substring(1, str.length());
        // upperCase = upperCase.toUpperCase();
        // str = upperCase + lowerCase;

        // StringBuffer strb = new StringBuffer(str);
        // for (int i = 0; i < str.length(); i++) {
        //     if (strb.charAt(i) == '.') {
        //         char replace = strb.charAt(i + 2);
        //         strb.setCharAt(i + 2, Character.toUpperCase(replace));
        //     }
        // }
        // return strb.toString();
        str = str.substring(3);
        StringBuffer buffer = new StringBuffer(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                buffer.setCharAt(i, Character.toUpperCase(str.charAt(i)));
                break;
            }
        }
        return buffer.toString();
    }

    public String afterDotUpperCase(String str) {
        StringBuffer buffer = new StringBuffer(str);
        int size = buffer.length();
        for (int i = 0; i < size - 2; i++) {
            if (buffer.charAt(i) == '.') {
                char uppercase = buffer.charAt(i + 2);
                buffer.setCharAt(i + 2, Character.toUpperCase(uppercase));
            }
        }
        return buffer.toString();
    }
    
    int count = 0;
    
    public String SpaceQuotes(String str) {
        StringBuffer buffer = new StringBuffer(str);
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == '"' /* || (buffer.charAt(i) == '”' && buffer.charAt(i) == '“') */ && count % 2 == 0) {
                buffer.deleteCharAt(i + 1);
                count++;
            } else if (buffer.charAt(i) == '"' /* || (buffer.charAt(i) == '”' && buffer.charAt(i) == '“') */ && count % 2 == 1
                    && i != 0) {
                buffer.deleteCharAt(i - 1);
                count++;
            }
        }
        return buffer.toString();

        //* v2 */
        // str = str.replaceAll("\\s*\"\\s*", " \"");
        // str = str.replaceAll("\"\\s+", "\"");
        // str = str.replaceAll("\\s+\"", "\" ");
        // str = str.replaceAll("“", "\"");
        // str = str.replaceAll("”", "\"");
        // return str;
    }

    public String dotLastLine(String str) {
        if (str.endsWith(".")) {
            return str;
        }
        else {
            return str + ".";
        }
    }

}
