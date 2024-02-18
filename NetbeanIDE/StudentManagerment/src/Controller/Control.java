/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import java.util.ArrayList;

import View.Manage;
import View.Menu;
import java.util.List;

public class Control extends Menu{
    
    final Manage mng = new Manage();
    List<Student> std = new ArrayList<>();
    
    public Control() {
        super("WELCOME TO STUDENT MANAGEMENT \n--------------------------------",
                new String[]{"Create student",
                    "Find and sort student",
                    "Update/Delete student",
                    "Report",
                    "Exit the program"});
        std = new ArrayList<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                mng.createStudent();
            case 2 ->
                mng.FindAndSortStudent();
            case 3 ->
                mng.UpdateAndDeleteStudent();
            case 4 -> {
                mng.displayAllStudents();
                mng.Report();
            }
            case 5 ->
                System.out.println("Exited. Bye bye");
            default ->
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
