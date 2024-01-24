package Controller;

import java.io.*;
import java.util.Scanner;

import Model.Model;
import View.Menu;

public class Reader extends Menu {
    //! file can be everywhere, can't fix
    // * When the code run, please don't fix it!//
    private Model model = new Model();
    private newControl controller = new newControl();
    private final Scanner sc = new Scanner(System.in);

    public Reader() {
        super("Normalize Text", new String[]{"Import", "Normalize", "Exit"});
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                importFile();
                break;
            case 2:
                reader(new File(model.getInput()));
                displayOutput();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    private void importFile() {
        System.out.print("Enter the full path of the text file you want to import: ");
        String filePath = sc.nextLine();
        File file = new File(filePath);

        if (file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
            System.out.println("File successfully imported: " + file.getName());
            model.setInput(file.getAbsolutePath());
        } else {
            System.out.println("Invalid file or file path. Returning to main menu...");
        }
    }

    private void reader(File file) {
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    buffer.append(line + " ");
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String line = buffer.toString();
        line = controller.oneSpaceNormal(line);
        line = controller.SpaceQuotes(line);
        line = controller.signNormal(line);
        line = controller.UpperCase(line);
        line = controller.afterDotUpperCase(line);
        line = controller.dotLastLine(line);
        writter(new StringBuffer(line));
    }

    private void writter(StringBuffer buffer) {
        System.out.print("Enter the full path for the output file: ");
        String outputPath = sc.nextLine();
        try {
            PrintWriter pw = new PrintWriter(outputPath);
            pw.print(buffer);
            pw.close();
            model.setOutput(outputPath);
            System.out.println("File successfully normalized and saved: " + outputPath);
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        }
    }

    private void displayOutput() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(model.getOutput()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    // public static void main(String[] args) {
    //     Reader reader = new Reader();
    //     reader.run();
    // }
}
