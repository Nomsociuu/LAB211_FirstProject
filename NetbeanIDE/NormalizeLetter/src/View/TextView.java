
package View;

import Model.TextModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TextView {
    
    private  List<TextModel> textModels;

    public TextView() {
    }
    
   
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void addFile() {
        System.out.println("Enter the input file name: ");
        String inputFileName = new Scanner(System.in).next(); // You can modify this based on your requirements

        System.out.println("Enter the output file name: ");
        String outputFileName = new Scanner(System.in).next(); // You can modify this based on your requirements

        TextModel textModel = new TextModel(inputFileName, outputFileName);
        textModels.add(textModel);

        displayMessage("File names added successfully.");
    }

    public void normalizeFiles() {
        if (!textModels.isEmpty()) {
            for (TextModel textModel : textModels) {
                try {
                    normalizeText(textModel);
                    displayMessage("Text normalization completed successfully for file: " + textModel.getInputFileName());
                } catch (IOException e) {
                    e.printStackTrace();
                    displayMessage("Error normalizing file: " + e.getMessage());
                }
            }
        } else {
            displayMessage("No files added. Please add files first.");
        }
    }

    public void normalizeText(TextModel textModel) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(textModel.getInputFileName()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(textModel.getOutputFileName()))) {

            boolean isFirstLine = true;
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    line = removeBlankLineBetweenLines(line);
                    line = removeSpacesInsideQuotes(line);
                    line = normalizeOneSpaceBetweenWords(line);
                    line = dotLastLine(line);
                    line = normalizeOneSpaceAfterPunctuation(line);
                    line = capitalizeAfterDot(line);
                    line = capitalizeFirstWordInFirstLine(line, isFirstLine);
                    line = removeSpaceBeforeCommaAndDot(line);

                    writer.write(line);
                    isFirstLine = false;
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading or writing file: " + e.getMessage());
        }
    }

    private String capitalizeAfterDot(String line) {
        StringBuilder sb = new StringBuilder(line);

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

    private static String dotLastLine(String str) {
        return str.endsWith(".") ? str : str + ".";
    }

    private static String normalizeOneSpaceAfterPunctuation(String line) {
        return line.replaceAll("\\s(?=[.,:])", "");
    }

    private static String normalizeOneSpaceBetweenWords(String line) {
        return line.replaceAll("\\s+", " ");
    }

    private static String removeSpacesInsideQuotes(String line) {
        line = line.replaceAll("\"\\s+", "\"");
        line = line.replaceAll("\\s+\"", "\"");
        return line;
    }

    private static String removeBlankLineBetweenLines(String line) {
        return line.trim();
    }

    private static String capitalizeFirstWordInFirstLine(String line, boolean isFirstLine) {
        return isFirstLine ? line.substring(0, 1).toUpperCase() + line.substring(1) : line;
    }

    private static String removeSpaceBeforeCommaAndDot(String line) {
        return line.replaceAll("(?<!\\s)[.,](?!\\s)", "$0 ");
    }
}
