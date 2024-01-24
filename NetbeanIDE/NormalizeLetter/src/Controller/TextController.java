package Controller;

import Model.TextModel;
import View.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextController {

    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
    }

    TextModel td = new TextModel();

    public void processText() {
        try {
            normalizeText();
            view.displayMessage("Text normalization completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    private void normalizeText() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(model.getInputFileName())); BufferedWriter writer = new BufferedWriter(new FileWriter(model.getOutputFileName()))) {

            boolean isFirstLine = true;
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    
                    
                    line = removeBlankLineBetweenLines(line); // ghép dòng
                    line = removeSpacesInsideQuotes(line); // xóa khoảng cách trong ngoặc
                    line = normalizeOneSpaceBetweenWords(line); // thêm 1 khảng cách giữa các chữ
                    
                    line = dotLastLine(line); //thêm dấu chấm cuối văn bản
                    line = normalizeOneSpaceAfterPunctuation(line); // thêm 1 dấu cách sau : , .
                    line = CapitalNormal(line); // Viết hoa chữ cái dầu sau dấu chấm và chữ cái phía sau viết thường
                    line = capitalizeFirstWordInFirstLine(line, isFirstLine); //Viết hoa chữ cái đầu tiên trong văn bản
                    line = removeSpaceBeforeCommaAndDot(line); //xóa dấu cách trước . và ,

                    writer.write(line);
                    isFirstLine = false;
                }
            }
            ensureDotAtEnd();
        } catch (IOException e) {
            throw new IOException("Error reading or writing file: " + e.getMessage());
        }
    }

    //done
    private static String normalizeOneSpaceBetweenWords(String line) {
        return line.replaceAll("\\s+", " ");
    }

    private static String normalizeOneSpaceAfterPunctuation(String line) {
        line = line.replaceAll("\\s(?=[.,:])", "");
        return line;
    }

//Capitalizing at the first letter and after dot
    public static String CapitalNormal(String text) {
        text = text.toLowerCase();
        StringBuilder sb = new StringBuilder(text);

        // Capitalize the first letter
        if (sb.length() > 0) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        // Capitalize the letter after a dot
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '.' && Character.isWhitespace(sb.charAt(i + 1))) {
                if (i + 2 < sb.length()) {
                    sb.setCharAt(i + 2, Character.toUpperCase(sb.charAt(i + 2)));
                    i++; // Skip the next character as it's already processed
                }
            }
        }

        return sb.toString();
    }

//done 99% : problem delete all space front and behind "
    private static String removeSpacesInsideQuotes(String line) {
    // Loại bỏ khoảng trắng sau dấu ngoặc kép
    line = line.replaceAll("\"\\s+", "\"");

    // Loại bỏ khoảng trắng trước dấu ngoặc kép từ kí tự gần nhất
    line = line.replaceAll("\\s+\"", "\"");

    return line;
}

//done
    private static String capitalizeFirstWordInFirstLine(String line, boolean isFirstLine) {
        if (isFirstLine) {
            return line.substring(0, 1).toUpperCase() + line.substring(1);
        }
        return line;
    }

//done
    private static String removeBlankLineBetweenLines(String line) {
        return line.trim();
    }

//done
    private static String removeSpaceBeforeCommaAndDot(String line) {
        return line.replaceAll("(?<!\\s)[.,](?!\\s)", "$0 ");
    }

    private void ensureDotAtEnd() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(model.getOutputFileName())); BufferedWriter writer = new BufferedWriter(new FileWriter(model.getOutputFileName(), true))) {

            String lastLine = null;
            String currentLine;

            // Read the file to find the last non-empty line
            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.trim().isEmpty()) {
                    lastLine = currentLine;
                }
            }

            // Ensure there is a dot at the end of the last non-empty line
            if (lastLine != null && !lastLine.trim().endsWith(".")) {
                writer.write(".");
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error writing file: " + e.getMessage());
        }
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
