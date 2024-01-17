
package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;


public class ReadandSave {
    public void readDataFromFile(String filename) throws IOException, ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String studentName = parts[1];
                    int semester = Integer.parseInt(parts[2]);
                    String courseName = parts[3];
                    boolean fa = false;
                    // check validate
                    if (!fa) {
                        Student std = new Student(id, studentName, semester, courseName);
                        stdlist.add(std);
                    }
                    else{
                        System.out.println("Type wrong information format, type again!!!");
                    }
                }
            }
        }
    }

     
    public void saveDoctorsToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student std : stdlist) {
                writer.println(std.getid() + "," 
                        + std.getstudentName() + "," 
                        + std.getsemester() 
                        + "," + std.getcourseName());
                
            }
        } catch (IOException e) {
            throw new IOException("Failed to save data to file: " + filename);
        }
    }
}
