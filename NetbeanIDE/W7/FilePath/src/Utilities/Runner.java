package Utilities;

import Common.*;
import Model.*;

public class Runner {

    final Validate val = new Validate();
    final Model model = new Model();
    //String path = model.getPath();

    public String getPath(String path) {
        int getPath = path.indexOf("\\");
        int getLastPath = path.lastIndexOf("\\");
        return path.substring(getPath + 1, getLastPath);
    }

    public String getDiskDrive(String path) {
        int diskDrive = path.indexOf("\\");
        return path.substring(0, diskDrive);
    }

    public String getExtension(String path) {
        int getLastExtension = path.lastIndexOf(".");
        return path.substring(getLastExtension + 1, path.length());
    }

    public String getFileName(String path) {
        int fileName = path.lastIndexOf("\\");
        int getLastName = path.lastIndexOf(".");
        return path.substring(fileName + 1 , getLastName);
    }


    public String getFolder(String path) {
        int getLastPath = path.lastIndexOf("\\");
        if (getLastPath != -1) {
            String folderPath = path.substring(0, getLastPath);
            String[] folders = folderPath.split("\\\\");
            return "[" + folders[folders.length - 1] + "]"; 
        }
        return null; 
    }

    public void execute(String path) {
        System.out.println("Disk: " + getDiskDrive(path));
        System.out.println("Extension: " + getExtension(path));
        System.out.println("File name: " + getFileName(path));
        System.out.println("Path: " + getPath(path));
        System.out.println("Foler: " + getFolder(path));
    }
}



