package Controller;

import Model.TextModel;
import View.Menu;
import View.TextView;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextController extends Menu {

    private final TextView view;
    private List<TextModel> textModels;

    public TextController(TextView view) {
        super("WELCOME TO FILE NORMALIZER \n--------------------------------",
                new String[]{"Input file to read",
                    "Normalizing file",
                    "Exit the program"});
        this.view = view;
        this.textModels = new ArrayList<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                addFile();
                break;

            case 2:
                normalizeFiles();
                break;

            case 3:
                view.displayMessage("Exited. Bye bye");
                break;

            default:
                view.displayMessage("Invalid choice. Please try again.");
        }
    }

    private void addFile() {
        System.out.println("Enter the input file name: ");
        String inputFileName = new Scanner(System.in).next();

        System.out.println("Enter the output file name: ");
        String outputFileName = new Scanner(System.in).next();

        TextModel textModel = new TextModel(inputFileName, outputFileName);
        textModels.add(textModel);

        view.displayMessage("File names added successfully.");
    }

    private void normalizeFiles() {
        if (!textModels.isEmpty()) {
            for (TextModel textModel : textModels) {
                try {
                    view.normalizeText(textModel);
                    view.displayMessage("Text normalization completed successfully for file: " + textModel.getInputFileName());
                } catch (IOException e) {
                    view.displayMessage("Error normalizing file: " + e.getMessage());
                }
            }
        } else {
            view.displayMessage("No files added. Please add files first.");
        }
    }
}
