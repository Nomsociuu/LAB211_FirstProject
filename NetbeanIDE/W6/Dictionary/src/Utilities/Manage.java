package Utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import Model.Words;
import Common.Validate;

public class Manage {
    final HashMap<String, Words> words = new HashMap<>();
    final Words word = new Words();
    //final HashMap<String, Eng> english = new HashMap<>();
    final Validate val = new Validate();

    public void addWord() {
        String eng = val.checkString("Enter English: ");
        String vie = val.checkString("Enter Vietnamese: ");
        Words w = new Words(eng, vie);
        words.put(eng, w);
        System.out.println("Word added successfully!");
    }

    // public static void main(String[] args) {
    //     new Manage().addWord();
    // }

    public void deleteWord() {
        String eng;
        boolean isExist;
        do {
            eng = val.checkString("Enter English: ");
            isExist = false;
            for (String key : words.keySet()) {
                if (key.equalsIgnoreCase(eng)) {
                    words.remove(key);
                    System.out.println("Word deleted successfully!");
                    isExist = true;
                    break; // Exit the loop after deleting the word
                }
            }
            if (!isExist) {
                System.out.println("Word not found!");
            }
        } while (!isExist);
    }
    

    public void translateWord() {
        String eng;
        boolean isExist;
        do {
            eng = val.checkString("Enter English: ");
            isExist = false;
            for (String key : words.keySet()) {
                if (key.equalsIgnoreCase(eng)) {
                    System.out.println("Vietnamese: " + words.get(key).getVietnamese());
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Word not found! Try again.");
            }
        } while (!isExist);
    }

    public void readFile(String filename) {
        try{
            BufferedReader read = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String eng = parts[0].trim();
                    String vie = parts[1].trim();
                    Words w = new Words(eng, vie);
                    words.put(eng, w);
                }
            } 
        }
        catch(Exception e){
            System.out.println("File not found!");
        }
    }

    public void writeFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Words> entry : words.entrySet()) {
                String eng = entry.getKey();
                String vie = entry.getValue().getVietnamese();
                writer.write(eng + ", " + vie);
                writer.newLine();
            }
            System.out.println("Words written to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
